package study.eatgo.domain.restaurant.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@ToString(of = {"name", "foodCategory"})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "food_category", nullable = false)
    private FoodCategory foodCategory;

//    //boolean이 추가되면 롬복에서 자동으로 is라는 함수 넣어줌.
//    @Transient  // DB에는 반영 안할거임.
//    @JsonInclude(Include.NON_DEFAULT)   // DEFAULT가 아닐 때, boolean의 default는 false이므로 true일 때만 넣어라.
//    private boolean delete;

}
