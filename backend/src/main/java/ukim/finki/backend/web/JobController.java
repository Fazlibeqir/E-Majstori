package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.dto.JobDTO;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobProviderService;
import ukim.finki.backend.service.JobService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
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
    public List<Job> getJobs() {
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
    public ResponseEntity<Job> addJob(@RequestBody JobDTO jobDTO) {
        if(jobDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if (jobDTO.getTitle() == null || jobDTO.getDescription() == null || jobDTO.getPrice() == 0 || jobDTO.getJobProviderId() == null || jobDTO.getCategoryId() == null) {
            return ResponseEntity.badRequest().build();
        }
        if (isJobProviderNull(jobDTO)) return ResponseEntity.notFound().build();

        Job job = this.jobService.create(jobDTO);
        return ResponseEntity.ok().body(job);
    }

    private boolean isJobProviderNull(@RequestBody JobDTO jobDTO) {
        if (jobProviderService.findById(jobDTO.getJobProviderId()) == null) {
            return true;
        }
        List<Category> categories =jobDTO.getCategoryId().stream().map(categoryService::findById).collect(Collectors.toList());
        return categories.isEmpty();
    }

    @PostMapping("/edit-job/{id}")
    public ResponseEntity<Job> editJob(@PathVariable Long id,
                                       @RequestBody JobDTO jobDTO) {
        if(jobDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if (id == null || jobDTO.getTitle() == null || jobDTO.getDescription() == null || jobDTO.getPrice() == 0) {
            return ResponseEntity.badRequest().build();
        }
        if (isJobProviderNull(jobDTO)) return ResponseEntity.notFound().build();
        Job job = this.jobService.update(id, jobDTO);
        return ResponseEntity.ok().body(job);
    }

    @PostMapping("/delete-job/{id}")
    public ResponseEntity deleteJob(@PathVariable Long id) {
        if (id == null || jobService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        this.jobService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/grade-job/{id}")
    public ResponseEntity gradeJob(@PathVariable Long id,
                                   @RequestParam double grade) {
        if (id == null || jobService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        if (grade == 0)
            return ResponseEntity.badRequest().build();
        this.jobService.giveGrade(id, grade);
        return ResponseEntity.ok().build();
    }
}
