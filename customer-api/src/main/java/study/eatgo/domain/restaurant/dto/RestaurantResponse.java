package study.eatgo.domain.restaurant.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.restaurant.domain.Restaurant;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantResponse {

    private List<Restaurant> restaurants;

    public RestaurantResponse(final List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

}
