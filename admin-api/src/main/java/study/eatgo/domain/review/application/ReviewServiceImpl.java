package study.eatgo.domain.review.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.review.dao.ReviewRepository;
import study.eatgo.error.exceptions.RestaurantNotFoundException;
import study.eatgo.error.exceptions.ReviewNotFoundException;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final RestaurantRepository restaurantRepository;

    @Override
    public void deleteReview(Integer restaurantId, Integer reviewId) {
        restaurantRepository.findById(restaurantId)
            .orElseThrow(RestaurantNotFoundException::new);

        if (!reviewRepository.existsById(reviewId)) {
            throw new ReviewNotFoundException();
        } else {
            reviewRepository.deleteById(reviewId);
        }
    }
}
