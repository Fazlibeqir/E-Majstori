package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobProviderService;
import ukim.finki.backend.service.JobService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/job")
public class JobController {
    private final JobService jobService;
    private final JobProviderService jobProviderService;
    private final CategoryService categoryService;

    public JobController(JobService jobService, JobProviderService jobProviderService, CategoryService categoryService) {
        this.jobService = jobService;
        this.jobProviderService = jobProviderService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Job> getJobs(){
        return this.jobService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.findById(id);
        if (job != null) {
            return ResponseEntity.ok().body(job);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-job")
    public ResponseEntity<Job> addJob(@RequestParam String title,
                                        @RequestParam String description,
                                        @RequestParam double price,
                                        @RequestParam Long jobProviderId,
                                        @RequestParam Long categoryId){
        if(title == null || description == null || price == 0 || jobProviderId == null || categoryId == null){
            return  ResponseEntity.badRequest().build();
        }
        if(jobProviderService.findById(jobProviderId) == null || categoryService.findById(categoryId) == null){
            return ResponseEntity. notFound().build();
        }

        Job job = this.jobService.create(title, description, price, jobProviderId, categoryId);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/edit-job/{id}")
    public ResponseEntity<Job> editJob(@PathVariable Long id,
                                       @RequestParam String title,
                                       @RequestParam String description,
                                       @RequestParam double price,
                                       @RequestParam Long jobProviderId,
                                       @RequestParam Long categoryId){
        if(id == null || title == null || description == null || price == 0){
            return  ResponseEntity.badRequest().build();
        }
        if(jobProviderService.findById(jobProviderId) == null || categoryService.findById(categoryId) == null){
            return ResponseEntity. notFound().build();
        }
        Job job = this.jobService.update(id, title, description, price, jobProviderId, categoryId);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/delete-job/{id}")
    public ResponseEntity deleteJob(@PathVariable Long id){
        if(id == null || jobService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        this.jobService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
