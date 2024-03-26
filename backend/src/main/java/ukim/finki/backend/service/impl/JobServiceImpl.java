package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.repository.JobRepository;
import ukim.finki.backend.service.JobService;

import java.util.List;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;


    @Override
    public Job findById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }
}