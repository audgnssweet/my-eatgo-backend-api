package study.eatgo.domain.review.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.restaurant.application.RestaurantFindService;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.review.application.ReviewUpdateService;
import study.eatgo.domain.review.dto.ReviewAddRequest;

@RequiredArgsConstructor
@RestController
public class ReviewApi {

    private final RestaurantFindService restaurantFindService;

    private final ReviewUpdateService reviewUpdateService;

    @PostMapping("/restaurants/{restaurantId}/reviews")
    public void addReview(@PathVariable Long restaurantId, @RequestBody @Valid ReviewAddRequest dto) {
        final Restaurant restaurant = restaurantFindService.getRestaurantById(restaurantId);
        reviewUpdateService.addReview(dto, restaurant);
    }

}
