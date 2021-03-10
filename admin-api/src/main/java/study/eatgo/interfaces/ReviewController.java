package study.eatgo.interfaces;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.application.ReviewService;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @DeleteMapping("/restaurant/{restaurantId}/review/{reviewId}")
    public String deleteReview(
        @PathVariable Integer restaurantId,
        @PathVariable Integer reviewId
    ) {
        reviewService.deleteReview(restaurantId, reviewId);
        return "{}";
    }

}
