package study.eatgo.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.application.ReviewService;
import study.eatgo.dto.ReviewDto;

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
