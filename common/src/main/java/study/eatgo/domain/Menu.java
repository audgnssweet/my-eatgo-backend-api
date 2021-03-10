package study.eatgo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@Data
@Entity
public class Menu {

    @Id
    @Column(name = "menu_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)  //ToOne은 반드시 fetch LAZY 걸어줘야함.
    @JoinColumn(name = "restaurant_id") //외래키 조인. 테이블에 생성된다.
//    @JsonIgnoreProperties(value = {"menuItems", "reviews"})
//    @JsonIgnore
    private Restaurant restaurant;

//    //boolean이 추가되면 롬복에서 자동으로 is라는 함수 넣어줌.
//    @Transient  // DB에는 반영 안할거임.
//    @JsonInclude(Include.NON_DEFAULT)   // DEFAULT가 아닐 때, boolean의 default는 false이므로 true일 때만 넣어라.
//    private boolean delete;

}
