package ukim.finki.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "job_provider")
@Data
@NoArgsConstructor
public class JobProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "jobProvider", cascade = CascadeType.ALL)
    private List<Job> jobsOffered;


    @OneToOne
    private Location location;
}
