package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.JobProvider;
import ukim.finki.backend.model.Location;
import ukim.finki.backend.model.dto.JobProviderDTO;
import ukim.finki.backend.repository.JobProviderRepository;
import ukim.finki.backend.repository.JobRepository;
import ukim.finki.backend.repository.LocationRepository;
import ukim.finki.backend.service.JobProviderService;
import ukim.finki.backend.service.JobService;
import ukim.finki.backend.service.LocationService;

import java.util.List;

@Service
@AllArgsConstructor
public class JobProviderServiceImpl implements JobProviderService {

    private final JobProviderRepository jobProviderRepository;
    private final LocationService locationService;

    @Override
    public JobProvider findById(Long id) {
        return jobProviderRepository.findById(id).orElse(null);
    }

    @Override
    public List<JobProvider> findAll() {
        return jobProviderRepository.findAll();
    }

    @Override
    public JobProvider create(JobProviderDTO jobProviderDTO) {
        Location location = locationService.findById(jobProviderDTO.getLocationId());
        return jobProviderRepository.save(new JobProvider(jobProviderDTO.getName(), jobProviderDTO.getDescription(), location));
    }

    @Override
    public JobProvider update(Long id, JobProviderDTO jobProviderDTO) {
        JobProvider jobProvider = this.findById(id);
        Location location = locationService.findById(jobProviderDTO.getLocationId());
        jobProvider.setName(jobProviderDTO.getName());
        jobProvider.setDescription(jobProviderDTO.getDescription());
        jobProvider.setLocation(location);
        return jobProviderRepository.save(jobProvider);
    }

    @Override
    public void deleteById(Long id) {
        jobProviderRepository.deleteById(id);
    }

}