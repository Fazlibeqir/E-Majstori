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

    @Override
    public AppUser create(String firstName, String lastName, String username, String email, String password, String phoneNumber) {
        AppUser user = new AppUser(firstName, lastName, username, email, password, phoneNumber);
        return appUserRepository.save(user);
    }

    @Override
    public AppUser update(Long id, String firstName, String lastName, String username, String email, String password, String phoneNumber) {
        AppUser user = this.findById(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        return appUserRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.appUserRepository.deleteById(id);
    }
}
