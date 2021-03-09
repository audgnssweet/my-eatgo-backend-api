package study.eatgo.interfaces;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.application.MenuItemService;
import study.eatgo.dto.MenuItemDto;

@RequiredArgsConstructor
@RestController
public class MenuItemController {

    private final MenuItemService menuItemService;

    //menuitems는 너무 많으므로 bulk update를 사용할 것.
    //그리고 보내는 쪽에서 menuitem에다가 id를 넣어서 보내주면 수정이되고, 아니면 추가가된다.
    @PutMapping("/restaurant/{restaurantId}/menuitems")
    public String updateMenuitems(@PathVariable Integer restaurantId,
        @RequestBody List<MenuItemDto.Request> itemList) {
        menuItemService.updateMenuItems(restaurantId, itemList);
        return "{}";
    }

}
