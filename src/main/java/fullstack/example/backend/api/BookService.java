package fullstack.example.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> findBookByIsbn10(String isbn10) {
        return repository.findBookByIsbn10(isbn10);
    }
}
