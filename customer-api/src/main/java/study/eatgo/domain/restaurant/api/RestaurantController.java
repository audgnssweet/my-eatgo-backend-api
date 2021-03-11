package study.eatgo.domain.restaurant.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.restaurant.application.RestaurantService;
import study.eatgo.domain.restaurant.dto.RestaurantDto;
import study.eatgo.domain.restaurant.model.FoodCategory;
import study.eatgo.domain.restaurant.model.Region;

@CrossOrigin    //CORS정책 피하기위해
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDto.Response> getRestaurantsByRegionAndFoodCategory(
        @RequestParam Region region,
        @RequestParam FoodCategory foodCategory
    ) {
//        System.out.println(restaurants.get(0).getReviews());  //toString 하면 무한참조 발생.
        return restaurantService.getRestaurantsByRegionAndFoodCategory(region, foodCategory);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDto.DetailResponse getRestaurantDetail(@PathVariable Integer restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

}
