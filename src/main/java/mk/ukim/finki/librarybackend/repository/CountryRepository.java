package mk.ukim.finki.librarybackend.repository;

import mk.ukim.finki.librarybackend.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
}
