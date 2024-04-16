package ukim.finki.backend.service;

import ukim.finki.backend.model.AppUser;

import java.util.List;
import java.util.Optional;

public interface AppUserService {
    AppUser findById(Long id);
    List<AppUser> findAll();
    AppUser create(String firstName, String lastName, String username, String email, String password, String phoneNumber);
    AppUser update(Long id, String firstName, String lastName, String username, String email, String password, String phoneNumber);
    void deleteById(Long id);
}