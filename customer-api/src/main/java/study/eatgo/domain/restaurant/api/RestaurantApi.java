package study.eatgo.domain.restaurant.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.annotations.Member;
import study.eatgo.domain.restaurant.application.RestaurantMakeService;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.MyRestaurantResponse;
import study.eatgo.domain.restaurant.dto.RestaurantMakeRequest;
import study.eatgo.domain.user.domain.User;

@RequestMapping("/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantMakeService restaurantMakeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MyRestaurantResponse makeRestaurant(
        @RequestBody @Valid RestaurantMakeRequest dto,
        @Member User user
    ) {
        final Restaurant restaurant = restaurantMakeService.make(dto, user);
        return new MyRestaurantResponse(restaurant);
    }

}
