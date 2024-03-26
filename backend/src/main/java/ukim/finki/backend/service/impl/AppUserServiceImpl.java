package ukim.finki.backend.service.impl;

import org.springframework.stereotype.Service;
import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.repository.AppUserRepository;
import ukim.finki.backend.service.AppUserService;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUserServiceImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser findById(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
