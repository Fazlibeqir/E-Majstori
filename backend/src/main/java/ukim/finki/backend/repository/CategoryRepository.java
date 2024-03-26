package ukim.finki.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ukim.finki.backend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}