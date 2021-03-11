package study.eatgo.domain.restaurant.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.restaurant.application.RestaurantInfoService;
import study.eatgo.domain.restaurant.application.RestaurantUpdateService;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.MenuUpdateRequest;
import study.eatgo.domain.restaurant.dto.RestaurantMakeRequest;
import study.eatgo.domain.restaurant.dto.RestaurantResponse;
import study.eatgo.domain.review.application.ReviewRemoveService;

@RequestMapping("/restaurants")
@RequiredArgsConstructor
@RestController
public class RestaurantApi {

    private final RestaurantUpdateService restaurantUpdateService;

    private final ReviewRemoveService reviewRemoveService;

    private final RestaurantInfoService restaurantInfoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RestaurantResponse getRestaurantInfo(@PathVariable Long id) {
        final Restaurant restaurant = restaurantInfoService.getRestaurantInfo(id);
        return new RestaurantResponse(restaurant);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RestaurantResponse makeRestaurant(@RequestBody @Valid RestaurantMakeRequest dto) {
        final Restaurant restaurant = restaurantUpdateService.make(dto);
        return new RestaurantResponse(restaurant);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}/menu")
    public void updateMenu(@PathVariable Long id, @RequestBody @Valid MenuUpdateRequest dto) {
        restaurantUpdateService.updateMenu(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) {
        reviewRemoveService.removeAllInRestaurant(id);
        restaurantUpdateService.delete(id);
    }

}
