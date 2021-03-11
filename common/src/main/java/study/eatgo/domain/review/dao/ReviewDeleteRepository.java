package study.eatgo.domain.review.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.domain.review.domain.Review;

public interface ReviewDeleteRepository extends JpaRepository<Review, Long> {

    void removeAllByRestaurantId(Long RestaurantId);
}
