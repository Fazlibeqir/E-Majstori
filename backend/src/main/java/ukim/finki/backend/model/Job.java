package ukim.finki.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job")
@Data
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "description")
    private String description;

    @Column(name = "price",nullable = false)
    private double price;

    @ManyToOne
    private JobProvider jobProvider;

    @ManyToOne
    private Category category;
}
