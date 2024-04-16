package ukim.finki.backend.service;

import ukim.finki.backend.model.JobProvider;

import java.util.List;

public interface JobProviderService {
    JobProvider findById(Long id);
    List<JobProvider> findAll();
    JobProvider create(String name, Long locationId);
    JobProvider update(Long id, String name, Long locationId);
    void deleteById(Long id);
}