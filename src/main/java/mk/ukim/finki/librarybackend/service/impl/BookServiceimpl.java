package mk.ukim.finki.librarybackend.service.impl;

import mk.ukim.finki.librarybackend.model.Author;
import mk.ukim.finki.librarybackend.model.Book;
import mk.ukim.finki.librarybackend.model.Category;
import mk.ukim.finki.librarybackend.model.dto.BookDto;
import mk.ukim.finki.librarybackend.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.librarybackend.model.exceptions.BookNotFoundException;
import mk.ukim.finki.librarybackend.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.librarybackend.repository.AuthorRepository;
import mk.ukim.finki.librarybackend.repository.BookRepository;
import mk.ukim.finki.librarybackend.repository.CategoryRepository;
import mk.ukim.finki.librarybackend.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceimpl implements BookService {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    public BookServiceimpl(BookRepository bookRepository, CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findBookByName(name);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Transactional
    @Override
    public Optional<Book> saveBook(String name, Long categoryId, Long authorId, int availableCopies) {
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = new Book(name, category, author, availableCopies);
        this.bookRepository.save(book);

        return Optional.of(book);

    }

    @Override
    public Optional<Book> saveBook(BookDto bookDto) {
        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        //deletebyName

        Book book = new Book(bookDto.getName(), category, author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {

        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        Category category = this.categoryRepository.findById(bookDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(bookDto.getCategory()));

        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException(bookDto.getAuthor()));

        book.setName(bookDto.getName());
        book.setCategory(category);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        book.setAuthor(author);

        this.bookRepository.save(book);

        return Optional.of(book);
    }

    @Transactional
    public Optional<Book> edit(Long id, String name, Long categoryId, Long authorId, int availableCopies) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        Author author = this.authorRepository.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);

        this.bookRepository.save(book);

        return Optional.of(book);
    }


    @Override
    public void deleteById(Long id) {

        this.bookRepository.deleteById(id);

    }

    @Override
    public Optional<Book> markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        if(book.getAvailableCopies()==0)
            return Optional.of(book);
        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);

        return Optional.of(book);
    }
    @Override
    public Page<Book> findAllWithPagination(Pageable pageable) {
        return this.bookRepository.findAll(pageable);
    }
}
