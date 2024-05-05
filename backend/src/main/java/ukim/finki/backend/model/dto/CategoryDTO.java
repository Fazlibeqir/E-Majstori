package ukim.finki.backend.model.dto;

import lombok.Data;
import ukim.finki.backend.model.Job;

import java.util.ArrayList;
import java.util.List;

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
