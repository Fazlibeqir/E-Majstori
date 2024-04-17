package ukim.finki.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
public class Location{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city",nullable = false)
    private String city;


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<JobProvider> jobProviders;

    public Location(String city) {
        this.city = city;
        this.jobProviders = new ArrayList<>();
    }
}
