package ukim.finki.backend.model.dto;

import lombok.Data;

@Data
public class AppUserDTO {
    private String username;
    private String email;
    private String password;
    private String phoneNumber;

    public AppUserDTO() {
    }

    public AppUserDTO(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
}
