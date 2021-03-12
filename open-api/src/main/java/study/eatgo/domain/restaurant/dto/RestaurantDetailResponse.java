package study.eatgo.domain.restaurant.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.model.Menu;
import study.eatgo.domain.restaurant.model.Region;
import study.eatgo.domain.review.domain.Review;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class RestaurantDetailResponse {

    private String name;

    private Region region;

    private List<Menu> menuList;

    // RestaurantResponse를 만드는 책임도 스스로에게 부여함.
    public RestaurantDetailResponse(final Restaurant restaurant) {
        this.name = restaurant.getName();
        this.region = restaurant.getRegion();
        this.menuList = restaurant.getMenuList();
    }

}
