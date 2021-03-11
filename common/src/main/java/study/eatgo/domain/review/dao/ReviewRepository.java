package study.eatgo.domain.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.domain.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
