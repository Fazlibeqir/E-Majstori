package ukim.finki.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import ukim.finki.backend.model.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser findById(Long id);
    List<AppUser> findAll();
    AppUser create(String username,String phoneNumber,String email, String password);
    AppUser update(Long id,String username, String phoneNumber, String email, String password);
    void deleteById(Long id);
    UserDetails loadUserByEmail(String username);
}