package study.eatgo.domain.review.api;

import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.review.application.ReviewService;
import study.eatgo.domain.review.dto.ReviewDto;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/restaurant/{restaurantId}/review")
    public ResponseEntity<?> addReview(@PathVariable Integer restaurantId,
        @Valid @RequestBody ReviewDto.Request review) throws URISyntaxException {

        Integer reviewId = reviewService.addReview(restaurantId, review);
        URI uri = new URI("/restaurant/" + restaurantId + "/review/" + reviewId);
        return ResponseEntity.created(uri).body("{}");
    }

}
