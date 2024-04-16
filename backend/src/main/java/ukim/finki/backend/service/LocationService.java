package ukim.finki.backend.service;

import ukim.finki.backend.model.Location;

import java.util.List;

public interface LocationService {
    Location findById(Long id);
    List<Location> findAll();
    void deleteById(Long id);
    Location create(String city, String country);
}