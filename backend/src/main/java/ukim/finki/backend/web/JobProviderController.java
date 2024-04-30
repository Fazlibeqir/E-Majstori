package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.model.dto.JobProviderDTO;
import ukim.finki.backend.service.JobProviderService;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/jobProvider")
public class JobProviderController {
    private final JobProviderService jobProviderService;

    public JobProviderController(JobProviderService jobProviderService) {
        this.jobProviderService = jobProviderService;
    }

    @GetMapping
    public List<JobProvider> getJobProviders(){
        return this.jobProviderService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobProvider> getJobProviderById(@PathVariable Long id) {
        JobProvider jobProvider = this.jobProviderService.findById(id);
        if (jobProvider != null) {
            return ResponseEntity.ok().body(jobProvider);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-jobProvider")
    public ResponseEntity<JobProvider> addJobProvider(@RequestBody JobProviderDTO jobProviderDTO){
        if(jobProviderDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if(jobProviderDTO.getName() == null || jobProviderDTO.getLocationId() == null){
            return ResponseEntity.badRequest().build();
        }
        JobProvider jobProvider = this.jobProviderService.create(jobProviderDTO);
        return ResponseEntity.ok().body(jobProvider);
    }

    @PostMapping("/edit-jobProvider/{id}")
    public ResponseEntity<JobProvider> editJobProvider(@PathVariable Long id,
                                                       @RequestBody JobProviderDTO jobProviderDTO){
        if(jobProviderDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if(jobProviderDTO.getName() == null || jobProviderDTO.getLocationId() == null){
            return ResponseEntity.badRequest().build();
        }
        if(id == null || this.jobProviderService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        JobProvider jobProvider = this.jobProviderService.update(id, jobProviderDTO);
        return ResponseEntity.ok().body(jobProvider);
    }


    @DeleteMapping("/delete-jobProvider/{id}")
    public ResponseEntity deleteJobProbider(@PathVariable Long id){
        if(id == null || this.jobProviderService.findById(id) == null) {
            return ResponseEntity.badRequest().build();
        }
        this.jobProviderService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
