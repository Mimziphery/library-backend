package mk.ukim.finki.librarybackend.service;

import mk.ukim.finki.librarybackend.model.Book;
import mk.ukim.finki.librarybackend.model.dto.BookDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findByName(String name);

    Optional<Book> findById(Long id);

    @Transactional
    Optional<Book> saveBook(String name, Long categoryId, Long authorId, int availableCopies);

    Optional<Book> saveBook(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);

    Page<Book> findAllWithPagination(Pageable pageable);
}
