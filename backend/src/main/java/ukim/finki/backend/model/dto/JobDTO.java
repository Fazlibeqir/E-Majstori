package ukim.finki.backend.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class JobDTO {
    private String title;
    private String description;
    private double price;
    private Long jobProviderId;
    private List<Long> categoryId;

    public JobDTO() {
    }

    public JobDTO(String title, String description, double price, Long jobProviderId, List<Long> categoryId) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.jobProviderId = jobProviderId;
        this.categoryId = categoryId;
    }
}
