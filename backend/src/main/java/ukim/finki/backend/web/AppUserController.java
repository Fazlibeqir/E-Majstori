package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.model.dto.AppUserDTO;
import ukim.finki.backend.service.AppUserService;

import java.util.List;
@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/user")
public class AppUserController {
    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUser> getUsers(){
        return this.appUserService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUser> getUserById(@PathVariable Long id) {
        AppUser appUser = appUserService.findById(id);
        if (appUser != null) {
            return ResponseEntity.ok().body(appUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-user")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUserDTO appUserDTO){
        if(appUserDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if(appUserDTO.getEmail() == null || appUserDTO.getUsername() == null || appUserDTO.getPassword() == null){
            return  ResponseEntity.badRequest().build();
        }
        AppUser appUser = this.appUserService.create(appUserDTO);

        return ResponseEntity.ok().body(appUser);
    }

    @PostMapping("/edit-user/{id}")
    public ResponseEntity<AppUser> editUser(@PathVariable Long id,
                                        @RequestBody AppUserDTO appUserDTO){
        if(appUserDTO == null){
            return ResponseEntity.badRequest().build();
        }
        if(appUserDTO.getEmail() == null || appUserDTO.getUsername() == null || appUserDTO.getPassword() == null){
            return  ResponseEntity.badRequest().build();
        }
        if(id == null || appUserService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        this.appUserService.update(id, appUserDTO);

            return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        if(id == null || appUserService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }
        this.appUserService.deleteById(id);
            return ResponseEntity.ok().build();
    }

}
