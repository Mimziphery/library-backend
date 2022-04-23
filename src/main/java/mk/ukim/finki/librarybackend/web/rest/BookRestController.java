package mk.ukim.finki.librarybackend.web.rest;

import mk.ukim.finki.librarybackend.model.Book;
import mk.ukim.finki.librarybackend.model.dto.BookDto;
import mk.ukim.finki.librarybackend.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping
//    public List<Book> getBooks(){
//        return this.bookService.findAll();
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.saveBook(bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/mark/{id}")
    public ResponseEntity markAsTaken(@PathVariable Long id) {
        this.bookService.markAsTaken(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<Book> findAllWithPagination(Pageable pageable) {
        return this.bookService.findAllWithPagination(pageable).getContent();
    }


}