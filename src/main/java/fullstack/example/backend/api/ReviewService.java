package fullstack.example.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Review> findAllReviews() {
        return repository.findAll();
    }

    public Review createReview(String isbn10, String text) {
        Review review = repository.insert(new Review(text) );

        mongoTemplate.update(Book.class)
                .matching(Criteria.where("isbn10").is(isbn10))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}