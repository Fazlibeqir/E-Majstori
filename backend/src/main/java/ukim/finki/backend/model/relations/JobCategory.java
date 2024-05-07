package ukim.finki.backend.model.relations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import ukim.finki.backend.model.Category;
import ukim.finki.backend.model.Job;
import ukim.finki.backend.model.relations.combineId.JobCategoryPK;

@Entity
@Data
@NoArgsConstructor
@IdClass(JobCategoryPK.class)
@Table(name = "job_category")
public class JobCategory {

    @Id
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @JsonIgnoreProperties("category")
    private Job job_id;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonIgnoreProperties("jobs")
    private Category category_id;

    public JobCategory(Job job, Category category) {
        this.job_id = job;
        this.category_id = category;
    }
}
