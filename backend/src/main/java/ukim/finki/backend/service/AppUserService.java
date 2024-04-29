package ukim.finki.backend.service;

import org.springframework.security.core.userdetails.UserDetails;
import ukim.finki.backend.model.AppUser;

import java.util.List;

public interface AppUserService {
    AppUser findById(Long id);
    List<AppUser> findAll();
    AppUser create(
            String firstName, String lastName,String phoneNumber,
//            String username,
            String email, String password, String role);
    AppUser update(Long id,
                   String firstName, String lastName, String phoneNumber,
//                   String username,
                   String email, String password, String role);
    void deleteById(Long id);
    UserDetails loadUserByEmail(String username);
}