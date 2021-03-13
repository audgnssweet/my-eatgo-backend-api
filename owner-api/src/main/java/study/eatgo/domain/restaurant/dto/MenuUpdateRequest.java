package study.eatgo.domain.restaurant.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.restaurant.model.Menu;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MenuUpdateRequest {

    @Valid
    @NotNull
    private List<Menu> menuList;

}
