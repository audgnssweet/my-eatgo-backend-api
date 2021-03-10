package study.eatgo.interfaces;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.application.MenuService;
import study.eatgo.dto.MenuDto;

@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuService menuService;

    //menuitems는 너무 많으므로 bulk update를 사용할 것.
    //그리고 보내는 쪽에서 menuitem에다가 id를 넣어서 보내주면 수정이되고, 아니면 추가가된다.
    @PutMapping("/restaurant/{restaurantId}/menus")
    public String updateMenus(@PathVariable Integer restaurantId,
        @RequestBody List<MenuDto.Request> menus) {
        menuService.updateMenuItems(restaurantId, menus);
        return "{}";
    }

}
