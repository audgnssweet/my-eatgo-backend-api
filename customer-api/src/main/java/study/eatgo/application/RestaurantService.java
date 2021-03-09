package study.eatgo.application;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.dto.RestaurantDto;
import study.eatgo.enumer.Region;

public interface RestaurantService {

    @Transactional(readOnly = true)
    List<RestaurantDto.Response> getRestaurantsByRegionAndFoodCategory(Integer regionId, Integer foodCategoryId);

    @Transactional(readOnly = true)
    RestaurantDto.DetailResponse getRestaurantById(Integer restaurantId);

}
