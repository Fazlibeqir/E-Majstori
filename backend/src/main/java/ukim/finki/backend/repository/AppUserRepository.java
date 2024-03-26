package ukim.finki.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.backend.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

}