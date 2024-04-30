package ukim.finki.backend.service;

import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.JobProvider;

import java.util.List;
import java.util.function.DoubleBinaryOperator;

public interface JobService {
    Job findById(Long id);
    List<Job> findAll();
    void deleteById(Long id);
    Job create(String title, String description, double price, Long jobProviderId, Long categoryId);
    Job update(Long id, String title, String description, double price, Long jobProviderId, Long categoryId);
    void giveGrade(Long id, Double grade);
}
