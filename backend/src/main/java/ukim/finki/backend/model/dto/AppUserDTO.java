package ukim.finki.backend.model.dto;

import lombok.Data;

@Data
public class AppUserDTO {
     String firstName;
     String lastName;
     String username;
     String email;
     String password;
     String phoneNumber;
}
