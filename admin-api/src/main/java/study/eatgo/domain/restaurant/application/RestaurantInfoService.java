package study.eatgo.domain.restaurant.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;

@RequiredArgsConstructor
@Transactional
@Service
public class RestaurantInfoService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant getRestaurantInfo(Long id) {
        final Restaurant restaurant = restaurantRepository.findById(id)
            .orElseThrow(RestaurantNotFoundException::new);
        restaurant.getMenuList().get(0);
        return restaurant;
    }

}
