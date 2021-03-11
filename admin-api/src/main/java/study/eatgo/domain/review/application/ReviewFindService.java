package study.eatgo.domain.review.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.review.dao.ReviewRepository;
import study.eatgo.domain.review.domain.Review;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewFindService {

    private final ReviewRepository reviewRepository;

    public List<Review> findAll(Long restaurantId) {
        return reviewRepository.findAllByRestaurantId(restaurantId);
    }

}
