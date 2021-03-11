package study.eatgo.domain.restaurant.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.restaurant.model.Region;

@RequiredArgsConstructor
@Transactional
@Service
public class RestaurantFindService {

    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getRestaurantsByRegion(Region region) {
        return restaurantRepository.findAllByRegion(region);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(RestaurantNotFoundException::new);
    }

}
