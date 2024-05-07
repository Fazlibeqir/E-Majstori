package ukim.finki.backend.model.relations.combineId;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
public class JobCategoryPK implements Serializable {
    private Long job_id;
    private Long category_id;

    public JobCategoryPK(Long job, Long category) {
        this.job_id = job;
        this.category_id = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobCategoryPK that)) return false;
        return Objects.equals(getJob_id(), that.getJob_id()) &&
                Objects.equals(getCategory_id(), that.getCategory_id());
    }

    @Override
    public int hashCode() {
      return Objects.hash(getJob_id(), getCategory_id());
    }
}
