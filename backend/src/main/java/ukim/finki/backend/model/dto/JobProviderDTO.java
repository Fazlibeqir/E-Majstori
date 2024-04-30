package ukim.finki.backend.model.dto;

import lombok.Data;

@Data
public class JobProviderDTO {
    private String name;
    private String description;
    private Long locationId;

    public JobProviderDTO() {
    }

    public JobProviderDTO(String name, String description, Long locationId) {
        this.name = name;
        this.description = description;
        this.locationId = locationId;
    }
}
