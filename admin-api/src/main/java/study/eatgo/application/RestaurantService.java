package study.eatgo.application;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.dto.RestaurantDto;

public interface RestaurantService {

    @Transactional(readOnly = true)
    List<RestaurantDto.Response> getRestaurants();

    @Transactional(readOnly = true)
    RestaurantDto.DetailResponse getRestaurantById(Integer restaurantId);

    @Transactional
    Integer saveRestaurant(RestaurantDto.Request restaurant);

    @Transactional
    void updateRestaurant(Integer restaurantId, RestaurantDto.Request restaurant);
}
