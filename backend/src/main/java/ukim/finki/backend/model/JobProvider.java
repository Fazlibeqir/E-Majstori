package ukim.finki.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_provider")
@Data
@NoArgsConstructor
public class JobProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "jobProvider", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Job> jobsOffered;

    @ManyToOne
    private Location location;

    public JobProvider(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.jobsOffered = new ArrayList<>();
    }
}
