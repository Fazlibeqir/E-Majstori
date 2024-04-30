package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.repository.JobRepository;
import ukim.finki.backend.service.CategoryService;
import ukim.finki.backend.service.JobProviderService;
import ukim.finki.backend.service.JobService;

import java.util.List;

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
    public void deleteById(Long id) {
        this.jobRepository.deleteById(id);
    }

    @Override
    public Job create(String title, String description, double price, Long jobProviderId, Long categoryId) {
        JobProvider jobProvider = jobProviderService.findById(jobProviderId);
        Category category = categoryService.findById(categoryId);
        Job job = new Job(title, description, price, jobProvider, category);
        return jobRepository.save(job);
    }

    @Override
    public Job update(Long id, String title, String description, double price, Long jobProviderId, Long categoryId) {
        Job job = this.findById(id);
        Category category = categoryService.findById(categoryId);
        JobProvider jobProvider = jobProviderService.findById(jobProviderId);
        job.setTitle(title);
        job.setDescription(description);
        job.setPrice(price);
        job.setJobProvider(jobProvider);
        job.setCategory(category);
        return jobRepository.save(job);
    }

    @Override
    public void giveGrade(Long id, Double grade) {
        Job job = this.findById(id);
        double total_grades = job.getTotal_grades()+grade;
        int total_number_reviews = job.getNumber_reviews()+1;
        double new_grade = total_grades/total_number_reviews;
        job.setGrade(new_grade);
        job.setTotal_grades(total_grades);
        job.setNumber_reviews(total_number_reviews);
    }
}