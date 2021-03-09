package study.eatgo.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.eatgo.domain.RestaurantRepository;
import study.eatgo.domain.ReviewRepository;
import study.eatgo.exception.exceptions.RestaurantNotFoundException;
import study.eatgo.exception.exceptions.ReviewNotFoundException;

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
