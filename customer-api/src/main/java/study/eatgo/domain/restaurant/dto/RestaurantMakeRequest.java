package study.eatgo.domain.restaurant.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.model.Menu;
import study.eatgo.domain.restaurant.model.Region;
import study.eatgo.domain.user.domain.User;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class RestaurantMakeRequest {

    @Valid
    @NotEmpty
    @Size(max = 50)
    private String name;

    @Valid
    @NotNull
    private Region region;

    @Valid
    @NotNull
    private List<Menu> menuList;

    /*
    Entity로 바꾸는 책임을 스스로에게 지게 한다.
     */
    public Restaurant toEntity(final User user) {
        return Restaurant.builder()
            .name(name)
            .user(user)
            .region(region)
            .menuList(menuList)
            .build();
    }

}
