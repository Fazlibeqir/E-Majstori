package ukim.finki.backend.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ukim.finki.backend.model.AppUser;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Location;
import ukim.finki.backend.service.AppUserService;

import java.util.List;
//Ova Za adminot mozebi ke treba da se napravi posebno , za da moze da gi gleda site korisnici
// i da gi brise i editira
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
    public ResponseEntity<AppUser> addUser(
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String phoneNumber,
//                                        @RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String role){
        if(email == null || password == null
                || firstName == null || lastName == null
//               || username == null
        ){
            return  ResponseEntity.notFound().build();
        }

        AppUser appUser = this.appUserService.create(
                firstName, lastName,phoneNumber,
//                username,
                email, password, role);
        return ResponseEntity.ok().body(appUser);
    }

    @PostMapping("/edit-user/{id}")
    public ResponseEntity<AppUser> editUser(@PathVariable Long id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String phoneNumber,
//                                        @RequestParam String username,
                                        @RequestParam String email,
                                        @RequestParam String password,
                                        @RequestParam String role){
        if(email == null || password == null
//                || firstName == null || lastName == null || username == null
        ){
            return  ResponseEntity.notFound().build();
        }

        if(id == null || appUserService.findById(id) == null){
            return ResponseEntity.notFound().build();
        }

        this.appUserService.update(id,
                firstName, lastName,phoneNumber,
//                username,
                email, password, role);
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
