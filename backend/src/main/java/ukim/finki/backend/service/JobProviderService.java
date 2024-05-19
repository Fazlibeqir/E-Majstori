package ukim.finki.backend.service;

import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.model.dto.JobDTO;
import ukim.finki.backend.model.dto.JobProviderDTO;

import java.util.List;

public interface JobProviderService {
    JobProvider findById(Long id);
    List<JobProvider> findAll();
    JobProvider create(JobProviderDTO jobProviderDTO);
    JobProvider update(Long id, JobProviderDTO jobProviderDTO);
    void deleteById(Long id);
}