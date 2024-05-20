package ukim.finki.backend.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.model.dto.AppUserDTO;
import ukim.finki.backend.repository.AppUserRepository;
import ukim.finki.backend.service.AppUserService;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService , UserDetailsService {

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
    public AppUser create(AppUserDTO appUserDTO) {
        this.appUserRepository.deleteByUsername(appUserDTO.getUsername());// Why ?
        AppUser user = new AppUser(appUserDTO.getUsername(), appUserDTO.getEmail(), appUserDTO.getPassword(), appUserDTO.getPhoneNumber());
        return appUserRepository.save(user);
    }

    @Override
    public AppUser update(Long id, AppUserDTO appUserDTO) {
        AppUser user = this.findById(id);
        user.setUsername(appUserDTO.getUsername());
        user.setEmail(appUserDTO.getEmail());
        user.setPassword(appUserDTO.getPassword());
        user.setPhoneNumber(appUserDTO.getPhoneNumber());

        return appUserRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.appUserRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByEmail(String username) {
        return loadUserByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        if(identifier.contains("@")){
            return appUserRepository.findByEmail(identifier).orElseThrow(() -> new UsernameNotFoundException("User with email " + identifier + " was not found"));
        }else {
            return appUserRepository.findByUsername(identifier).orElseThrow(() -> new UsernameNotFoundException("User with username " + identifier + " was not found"));
        }
    }
}
