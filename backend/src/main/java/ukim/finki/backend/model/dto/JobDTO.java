package ukim.finki.backend.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.JobProvider;

@Data
public class JobDTO {
    private String title;
    private String description;
    private double price;
    private double grade;
    private double total_grades;
    private int number_reviews;
    private Long jobProviderId;
    private Long categoryId;

    public JobDTO() {
    }

    public JobDTO(String title, String description, double price, Long jobProviderId, Long categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.grade = 0.0;
        this.total_grades = 0.0;
        this.number_reviews = 0;
        this.jobProviderId = jobProviderId;
        this.categoryId = categoryId;
    }
}
