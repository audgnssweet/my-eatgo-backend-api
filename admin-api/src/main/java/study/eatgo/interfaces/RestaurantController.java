package study.eatgo.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.application.RestaurantService;
import study.eatgo.dto.RestaurantDto;

@CrossOrigin    //CORS정책 피하기위해
@RequiredArgsConstructor
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<RestaurantDto.Response> getRestaurants() {
//        System.out.println(restaurants.get(0).getReviews());  //toString 하면 무한참조 발생.
        return restaurantService.getRestaurants();
    }

    @GetMapping("/restaurant/{restaurantId}")
    public RestaurantDto.DetailResponse getRestaurantDetail(@PathVariable Integer restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    //스프링에서 제공하는 ResponseEntity 사용 생성시 자원까지 같이반환
    @PostMapping("/restaurant")
    public ResponseEntity<?> createRestaurant(@Valid @RequestBody RestaurantDto.Request restaurant)
        throws URISyntaxException {

        Integer restaurantId = restaurantService.saveRestaurant(restaurant);

        URI location = new URI("/restaurant/" + restaurantId);
        return ResponseEntity.created(location).body("{}");
    }

    @PutMapping("/restaurant/{restaurantId}")
    public String updateRestaurant(@PathVariable Integer restaurantId,
        @Valid @RequestBody RestaurantDto.Request restaurant) {
        restaurantService.updateRestaurant(restaurantId, restaurant);
        return "{}";
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public String deleteRestaurant(@PathVariable Integer restaurantId) {
        restaurantService.deleteRestaurant(restaurantId);
        return "{}";
    }

}
