package study.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
import study.eatgo.enumer.FoodCategory;
import study.eatgo.enumer.FoodCategoryConverter;
import study.eatgo.enumer.Region;
import study.eatgo.enumer.RegionConverter;

@AllArgsConstructor
@NoArgsConstructor
@Builder    //속성이 많아질수록 Builder을 쓰는 것이 유리하다.
@Accessors(chain = true)
@Data
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String address;

    private String information;

    @Convert(converter = RegionConverter.class) //ENUM 타입. 숫자로 저장하기 위함.
    @NotNull
    private Region region;

    @Convert(converter = FoodCategoryConverter.class)
    @NotNull
    private FoodCategory foodCategory;

    //DB에서 이렇게처리말고 개발시 이거그냥 임시야 -> @Transient -> DB에 안넣을거임.
    //REMOVE말고 ALL로 해놓으면 오류생김.
//    @JsonInclude(Include.NON_EMPTY) //NULL이 아닐 때만 json으로 만들 때 넣어줘라.
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
//    @JsonIgnoreProperties(value = "restaurant")
    @OrderBy("id")
    private List<MenuItem> menuItems;

//    @JsonInclude(Include.NON_EMPTY)
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.REMOVE)
//    @JsonIgnoreProperties(value = "restaurant")
    @OrderBy("score")
    private List<Review> reviews;


}
