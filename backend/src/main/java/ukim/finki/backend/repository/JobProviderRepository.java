package ukim.finki.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.backend.model.JobProvider;

@Repository
public interface JobProviderRepository extends JpaRepository<JobProvider, Long> {

}
