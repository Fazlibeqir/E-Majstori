package ukim.finki.backend.model.dto;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    private String imageUrl;


    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }
}
