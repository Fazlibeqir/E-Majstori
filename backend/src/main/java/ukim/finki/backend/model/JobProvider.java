package ukim.finki.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class JobProvider extends AppUser {

    @OneToMany(mappedBy = "jobProvider", cascade = CascadeType.ALL)
    private List<Job> jobsOffered;

    @Column(nullable = false)
    @OneToOne
    private Location location;
}
