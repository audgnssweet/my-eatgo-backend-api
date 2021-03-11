package study.eatgo.domain.review.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.review.application.ReviewFindService;
import study.eatgo.domain.review.domain.Review;
import study.eatgo.domain.review.dto.ReviewResponse;

@RequiredArgsConstructor
@RestController
public class ReviewApi {

    private final ReviewFindService reviewFindService;

    @GetMapping("/restaurants/{restaurantId}/reviews")
    public ReviewResponse getReviews(@PathVariable Long restaurantId) {
        List<Review> reviews = reviewFindService.findAll(restaurantId);
        return new ReviewResponse(reviews);
    }
}
