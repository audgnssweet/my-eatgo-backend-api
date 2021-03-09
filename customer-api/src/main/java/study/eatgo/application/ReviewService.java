package study.eatgo.application;

import study.eatgo.dto.ReviewDto;

public interface ReviewService {

    Integer addReview(Integer restaurantId, ReviewDto.Request review);
}
