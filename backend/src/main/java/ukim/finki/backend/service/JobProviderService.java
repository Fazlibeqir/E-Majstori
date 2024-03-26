package ukim.finki.backend.service;

import ukim.finki.backend.model.JobProvider;

import java.util.List;

public interface JobProviderService {
    JobProvider findById(Long id);
    List<JobProvider> findAll();
}