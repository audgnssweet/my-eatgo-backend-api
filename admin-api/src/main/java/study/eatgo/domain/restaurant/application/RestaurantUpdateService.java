package study.eatgo.domain.restaurant.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.MenuUpdateRequest;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.user.domain.User;

@RequiredArgsConstructor
@Transactional
@Service
public class RestaurantUpdateService {

    private final RestaurantRepository restaurantRepository;

    public void delete(User user) {

        restaurantRepository.deleteById(user.getRestaurant().getId());
    }

    public void updateMenu(Long id, MenuUpdateRequest dto) {
        final Restaurant restaurant = restaurantRepository.findById(id)
            .orElseThrow(RestaurantNotFoundException::new);

        restaurant.updateMenuList(dto.getMenuList());
    }
}
