package ukim.finki.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.backend.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}