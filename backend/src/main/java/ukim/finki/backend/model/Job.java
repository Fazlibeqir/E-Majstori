package ukim.finki.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ukim.finki.backend.model.relations.JobCategory;

import java.util.List;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
@ToString(exclude = {"jobProvider", "category"})
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long job_id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "grade")
    private Double grade;

    @Column(name = "total_grades")
    private Double total_grades;

    @Column(name = "number_reviews")
    private Integer number_reviews;

    @ManyToOne
    @JoinColumn(name = "jobProvider_id", referencedColumnName = "id")
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
