package ukim.finki.backend.service;

import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.model.dto.AppUserDTO;

import java.util.List;

public interface AppUserService {
    AppUser findById(Long id);
    List<AppUser> findAll();
    AppUser create(AppUserDTO appUserDTO);
    AppUser update(Long id, AppUserDTO appUserDTO);
    void deleteById(Long id);
}