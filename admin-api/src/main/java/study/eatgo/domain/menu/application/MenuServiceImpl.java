package study.eatgo.domain.menu.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.menu.domain.Menu;
import study.eatgo.domain.menu.dao.MenuRepository;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.dao.RestaurantRepository;
import study.eatgo.domain.menu.dto.MenuDto;
import study.eatgo.error.exceptions.MenuNotFoundException;
import study.eatgo.error.exceptions.RestaurantNotFoundException;

@RequiredArgsConstructor
@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    private final RestaurantRepository restaurantRepository;

    //생성과 업데이트, Delete까지 세 개가 한 로직으로 가능.
    @Override
    @Transactional
    public void updateMenuItems(Integer restaurantId, List<MenuDto.Request> menus) {
        final Restaurant foundRestaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(RestaurantNotFoundException::new);

        menus.forEach(menu -> {
            bulkUpdate(foundRestaurant, menu);
        });
    }

    //추가, 삭제, 수정을 한번에.
    private void bulkUpdate(Restaurant foundRestaurant, MenuDto.Request menu) {
        if (menu.isDelete()) {
            menuRepository.deleteById(menu.getId());
            return;
        }

        if (menu.getId() != null) {
            final Menu foundItem = menuRepository.findById(menu.getId())
                .orElseThrow(MenuNotFoundException::new);
            foundItem.setName(menu.getName());
            menuRepository.save(foundItem);
        } else {
            final Menu saving = Menu.builder()
                .name(menu.getName())
                .restaurant(foundRestaurant)
                .build();
            menuRepository.save(saving);
        }
    }
}
