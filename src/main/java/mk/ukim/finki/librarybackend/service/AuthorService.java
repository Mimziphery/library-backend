package mk.ukim.finki.librarybackend.service;

import mk.ukim.finki.librarybackend.model.Author;

import java.util.List;

public interface AuthorService {
    List<Author> findAll();
}
