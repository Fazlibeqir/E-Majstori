package ukim.finki.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "job_provider")
@Data
@NoArgsConstructor
@ToString(exclude = {"appUser", "jobsOffered"})
public class JobProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image")
    private String imageUrl;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "jobProvider", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("jobProvider")
    private List<Job> jobsOffered;

    @ManyToOne
    @JsonIgnoreProperties("jobProviders")
    private Location location;

    @OneToOne
    @JoinColumn(name = "app_user_id")
    @JsonIgnoreProperties("jobProvider")
    private AppUser appUser;

    public JobProvider(String name, String description, Location location) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.jobsOffered = new ArrayList<>();
    }
}
