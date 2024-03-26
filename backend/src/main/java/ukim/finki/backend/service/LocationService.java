package ukim.finki.backend.service;

import ukim.finki.backend.model.Location;

import java.util.List;

public interface LocationService {
    Location findById(Long id);
    List<Location> findAll();
}