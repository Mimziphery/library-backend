package mk.ukim.finki.librarybackend.service;

import mk.ukim.finki.librarybackend.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
}
