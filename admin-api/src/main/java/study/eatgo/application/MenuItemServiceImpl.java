package study.eatgo.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.MenuItem;
import study.eatgo.domain.MenuItemRepository;
import study.eatgo.domain.Restaurant;
import study.eatgo.domain.RestaurantRepository;
import study.eatgo.dto.MenuItemDto;
import study.eatgo.exception.exceptions.MenuItemNotFoundException;
import study.eatgo.exception.exceptions.RestaurantNotFoundException;

@RequiredArgsConstructor
@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;

    private final RestaurantRepository restaurantRepository;

    //생성과 업데이트, Delete까지 세 개가 한 로직으로 가능.
    @Override
    @Transactional
    public void updateMenuItems(Integer restaurantId, List<MenuItemDto.Request> menuItems) {
        final Restaurant foundRestaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(RestaurantNotFoundException::new);

        menuItems.forEach(menuItem -> {
            bulkUpdate(foundRestaurant, menuItem);
        });
    }

    //추가, 삭제, 수정을 한번에.
    private void bulkUpdate(Restaurant foundRestaurant, MenuItemDto.Request menuItem) {
        if (menuItem.isDelete()) {
            menuItemRepository.deleteById(menuItem.getId());
            return;
        }

        if (menuItem.getId() != null) {
            final MenuItem foundItem = menuItemRepository.findById(menuItem.getId())
                .orElseThrow(MenuItemNotFoundException::new);
            foundItem.setName(menuItem.getName());
            menuItemRepository.save(foundItem);
        } else {
            final MenuItem saving = MenuItem.builder()
                .name(menuItem.getName())
                .restaurant(foundRestaurant)
                .build();
            menuItemRepository.save(saving);
        }
    }
}
