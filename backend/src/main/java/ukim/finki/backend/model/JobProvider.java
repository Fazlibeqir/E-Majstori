package ukim.finki.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_provider")
@Data
@NoArgsConstructor
public class JobProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "jobProvider", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("jobProvider")
    private List<Job> jobsOffered;

    @ManyToOne
    @JsonIgnoreProperties("jobProviders")
    private Location location;

    public JobProvider(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.jobsOffered = new ArrayList<>();
    }
}
