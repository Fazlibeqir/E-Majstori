package ukim.finki.backend.service;

import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.dto.JobDTO;

import java.util.List;

public interface JobService {
    Job findById(Long id);
    List<Job> findAll();
    void deleteById(Long id);
    Job create(JobDTO jobDTO);
    Job update(Long id, JobDTO jobDTO);
    void giveGrade(Long id, Double grade);
}
