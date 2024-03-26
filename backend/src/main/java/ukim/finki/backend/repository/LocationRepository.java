package ukim.finki.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.backend.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}