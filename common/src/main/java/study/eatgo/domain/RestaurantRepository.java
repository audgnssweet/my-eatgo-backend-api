package study.eatgo.domain;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.enumer.FoodCategory;
import study.eatgo.enumer.Region;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    List<Restaurant> findAllByRegionAndFoodCategory(Region region, FoodCategory foodCategory);
}
