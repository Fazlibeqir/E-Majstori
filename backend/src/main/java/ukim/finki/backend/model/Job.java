package ukim.finki.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ukim.finki.backend.model.relations.JobCategory;

import java.util.List;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "grade")
    private double grade;

    @Column(name = "total_grades")
    private double total_grades;

    @Column(name = "number_reviews")
    private int number_reviews;

    @ManyToOne
    @JsonIgnoreProperties("jobsOffered")
    private JobProvider jobProvider;

    @OneToMany(mappedBy = "job_id", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JsonIgnoreProperties("jobs")
    private List<JobCategory> category;

    public Job(String title, String description, double price, JobProvider jobProvider, List<JobCategory> category) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.grade=0.0;
        this.total_grades=0.0;
        this.number_reviews=0;
        this.jobProvider = jobProvider;
        this.category = category;
    }
}
