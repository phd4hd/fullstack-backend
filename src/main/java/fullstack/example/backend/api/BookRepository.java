package fullstack.example.backend.api;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BookRepository extends MongoRepository<Book, ObjectId> {
    Optional<Book> findMovieByIsbn10(String isbn10);
}
