package study.eatgo.domain.review.application;

import study.eatgo.domain.review.dto.ReviewDto;

public interface ReviewService {

    Integer addReview(Integer restaurantId, ReviewDto.Request review);
}
