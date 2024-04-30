package ukim.finki.backend.model.dto;

import lombok.Data;

@Data
public class LocationDTO {
    private String city;

    public LocationDTO() {
    }

    public LocationDTO(String city) {
        this.city = city;
    }
}
