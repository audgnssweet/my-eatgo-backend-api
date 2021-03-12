package study.eatgo.domain.restaurant.api;

import io.jsonwebtoken.Claims;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.restaurant.application.RestaurantFindService;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.RestaurantResponse;
import study.eatgo.domain.restaurant.model.Region;

@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantFindService restaurantFindService;

    @GetMapping("/restaurants")
    public RestaurantResponse findRestaurantByRegion(@RequestParam Region region) {

        final List<Restaurant> restaurants = restaurantFindService
            .getRestaurantsByRegion(region);

        return new RestaurantResponse(restaurants);
    }
}
