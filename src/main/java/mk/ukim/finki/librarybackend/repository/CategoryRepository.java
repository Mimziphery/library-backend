package mk.ukim.finki.librarybackend.repository;

import mk.ukim.finki.librarybackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}