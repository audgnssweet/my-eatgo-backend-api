package study.eatgo.domain.review.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.domain.review.domain.Review;
import study.eatgo.domain.user.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByRestaurantId(Long restaurantId);

    List<Review> findAllByUser(User user);

}
