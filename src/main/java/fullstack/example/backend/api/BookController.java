package fullstack.example.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> getMovies() {
        return new ResponseEntity<>(
                service.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{isbn10}")
    public ResponseEntity<Optional<Book>> getSingleMovie(@PathVariable String isbn10){
        return new ResponseEntity<Optional<Book>>(service.findMovieByIsbn10(isbn10),
                HttpStatus.OK);
    }
}
