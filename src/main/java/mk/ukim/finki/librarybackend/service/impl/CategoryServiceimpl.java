package mk.ukim.finki.librarybackend.service.impl;

import mk.ukim.finki.librarybackend.model.Category;
import mk.ukim.finki.librarybackend.repository.CategoryRepository;
import mk.ukim.finki.librarybackend.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceimpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceimpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }
}
