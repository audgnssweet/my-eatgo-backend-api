package study.eatgo.domain.restaurant.application;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dto.RestaurantDto;
import study.eatgo.domain.restaurant.model.FoodCategory;
import study.eatgo.domain.restaurant.model.Region;

public interface RestaurantService {

    @Transactional(readOnly = true)
    List<RestaurantDto.Response> getRestaurantsByRegionAndFoodCategory(Region region, FoodCategory foodCategory);

    @Transactional(readOnly = true)
    RestaurantDto.DetailResponse getRestaurantById(Integer restaurantId);

}
