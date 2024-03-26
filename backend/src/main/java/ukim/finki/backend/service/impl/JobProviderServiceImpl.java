package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.repository.JobProviderRepository;
import ukim.finki.backend.service.JobProviderService;

import java.util.List;

@Service
@AllArgsConstructor
public class JobProviderServiceImpl implements JobProviderService {

    private final JobProviderRepository jobProviderRepository;

    @Override
    public JobProvider findById(Long id) {
        return jobProviderRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobProvider> findAll() {
        return jobProviderRepository.findAll();
    }
}