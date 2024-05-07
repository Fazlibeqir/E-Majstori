package ukim.finki.backend.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.Location;
import ukim.finki.backend.model.dto.LocationDTO;
import ukim.finki.backend.repository.LocationRepository;
import ukim.finki.backend.service.LocationService;

import java.util.List;


@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public Location findById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }

    @Override
    public Location create(LocationDTO locationDTO) {
        return locationRepository.save(new Location(locationDTO.getCity()));
    }
}