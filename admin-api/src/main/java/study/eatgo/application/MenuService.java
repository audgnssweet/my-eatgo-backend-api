package study.eatgo.application;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.dto.MenuDto;

public interface MenuService {

    //생성과 업데이트, Delete까지 세 개가 한 로직으로 가능.
    @Transactional
    void updateMenuItems(Integer restaurantId, List<MenuDto.Request> menus);
}
