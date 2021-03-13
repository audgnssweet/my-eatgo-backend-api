package study.eatgo.domain.restaurant.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dto.RestaurantMakeRequest;
import study.eatgo.domain.user.domain.User;

@RequiredArgsConstructor
@Transactional
@Service
public class RestaurantMakeService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant make(RestaurantMakeRequest dto, User user) {
        return restaurantRepository.save(dto.toEntity(user));
    }

}
