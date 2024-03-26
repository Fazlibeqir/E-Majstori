package ukim.finki.backend.service;

import ukim.finki.backend.model.Job;

import java.util.List;

public interface JobService {
    Job findById(Long id);
    List<Job> findAll();
}
