package ukim.finki.backend.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.model.dto.JobDTO;
import ukim.finki.backend.model.relations.JobCategory;
import ukim.finki.backend.repository.JobRepository;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobProviderService;
import ukim.finki.backend.service.JobService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final JobProviderService jobProviderService;
    private final CategoryService categoryService;

    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.jobRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Job create(JobDTO jobDTO) {
        JobProvider jobProvider = jobProviderService.findById(jobDTO.getJobProviderId());
        List<Category> categories= jobDTO.getCategoryId().stream()
                .map(categoryService::findById)
                .collect(Collectors.toList());

        Job job = new Job(jobDTO.getTitle(), jobDTO.getDescription(), jobDTO.getPrice(), jobProvider, null);
        Job savedJob = jobRepository.save(job);

        List<JobCategory> jobCategories = categories.stream()
                .map(category -> new JobCategory(savedJob, category))
                .collect(Collectors.toList());
        savedJob.setCategory(jobCategories);

        return jobRepository.save(savedJob);
    }

    @Override
    @Transactional
    public Job update(Long id, JobDTO jobDTO) {
        Job job = this.findById(id);
        JobProvider jobProvider = jobProviderService.findById(jobDTO.getJobProviderId());
        List<Category> categories = jobDTO.getCategoryId().stream()
                .map(categoryService::findById)
                .collect(Collectors.toList());
        job.setTitle(jobDTO.getTitle());
        job.setDescription(jobDTO.getDescription());
        job.setPrice(jobDTO.getPrice());
        job.setJobProvider(jobProvider);
        List<JobCategory> jobCategories = categories.stream()
                .map(category -> new JobCategory(job,category))
                .collect(Collectors.toList());
        job.setCategory(jobCategories);
        return jobRepository.save(job);
    }

    @Override
    @Transactional
    public void giveGrade(Long id, Double grade) {
        Job job = this.findById(id);
        double total_grades = job.getTotal_grades()+grade;
        int total_number_reviews = job.getNumber_reviews()+1;
        double new_grade = total_grades/total_number_reviews;
        job.setGrade(new_grade);
        job.setTotal_grades(total_grades);
        job.setNumber_reviews(total_number_reviews);
        jobRepository.save(job);
    }
}