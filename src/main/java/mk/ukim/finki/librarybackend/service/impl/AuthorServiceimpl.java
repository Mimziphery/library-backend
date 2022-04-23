package mk.ukim.finki.librarybackend.service.impl;

import mk.ukim.finki.librarybackend.model.Author;
import mk.ukim.finki.librarybackend.repository.AuthorRepository;
import mk.ukim.finki.librarybackend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceimpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceimpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }
}