package study.eatgo.domain.review.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.review.dao.ReviewRepository;
import study.eatgo.domain.review.domain.Review;
import study.eatgo.domain.review.dto.ReviewAddRequest;
import study.eatgo.domain.user.domain.User;

@RequiredArgsConstructor
@Transactional
@Service
public class ReviewUpdateService {

    private final ReviewRepository reviewRepository;

    public Review addReview(ReviewAddRequest dto, Restaurant restaurant, User user) {
        return reviewRepository.save(dto.toEntity(user, restaurant));
    }

}
