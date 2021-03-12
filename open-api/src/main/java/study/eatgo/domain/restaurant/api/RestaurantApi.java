package study.eatgo.domain.restaurant.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.restaurant.application.RestaurantFindService;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.RestaurantDetailResponse;
import study.eatgo.domain.restaurant.dto.RestaurantsResponse;
import study.eatgo.domain.restaurant.model.Region;
import study.eatgo.domain.review.application.ReviewFindService;
import study.eatgo.domain.review.domain.Review;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantFindService restaurantFindService;

    @GetMapping("/restaurants")
    public RestaurantsResponse findRestaurantByRegion(@RequestParam Region region) {

        final List<Restaurant> restaurants = restaurantFindService
            .getRestaurantsByRegion(region);

        return new RestaurantsResponse(restaurants);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/restaurants/{id}")
    public RestaurantDetailResponse getRestaurantInfo(@PathVariable Long id) {
        final Restaurant restaurant = restaurantFindService.getRestaurantById(id);
        return new RestaurantDetailResponse(restaurant);
    }

}
