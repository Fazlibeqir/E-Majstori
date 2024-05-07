package ukim.finki.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ukim.finki.backend.model.relations.JobCategory;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "image",nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonIgnoreProperties("category")
    private List<JobCategory> jobs;

    public Category(String name) {
        this.name = name;
        this.jobs = new ArrayList<>();
    }

    public Category(String name, List<JobCategory> jobs) {
        this.name = name;
        this.jobs = jobs;
    }
}
