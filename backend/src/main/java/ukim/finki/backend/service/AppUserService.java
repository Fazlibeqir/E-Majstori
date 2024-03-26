package ukim.finki.backend.service;

import ukim.finki.backend.model.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser findById(Long id);
    List<AppUser> findAll();
}