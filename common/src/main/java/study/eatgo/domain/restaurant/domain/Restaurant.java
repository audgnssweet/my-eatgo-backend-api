package study.eatgo.domain.restaurant.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import study.eatgo.domain.menu.domain.Menu;
import study.eatgo.domain.review.domain.Review;
import study.eatgo.domain.restaurant.model.FoodCategory;
import study.eatgo.domain.restaurant.model.Region;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Data
@Entity
public class Restaurant {

    @Id
    @Column(name = "restaurant_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Region region;

    @Enumerated(EnumType.STRING)
    private FoodCategory foodCategory;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @OrderBy("id")
    private List<Menu> menuItems;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    @OrderBy("score")
    private List<Review> reviews;

}
