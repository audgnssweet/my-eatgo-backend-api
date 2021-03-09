package study.eatgo.interfaces;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
