package study.eatgo.domain.restaurant.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import study.eatgo.domain.restaurant.model.Menu;
import study.eatgo.domain.restaurant.model.Region;

@EqualsAndHashCode(of = {"id"})
@ToString(of = {"name", "region"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "restaurant")
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50, unique = true, updatable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "region", nullable = false, updatable = false)
    private Region region;

    //이렇게하면 완전 종속 관계여서 자동으로 cascade REMOVE 적용.
    //그리고 기본적으로 LAZY 걸려있음.
    @ElementCollection
    @CollectionTable(name = "menu", joinColumns = @JoinColumn(name = "restaurant_id"))
    private List<Menu> menuList = new ArrayList<>();

    @CreationTimestamp
    @Column(name = "create_at", updatable = false, nullable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @Builder
    public Restaurant(String name, Region region, List<Menu> menuList) {
        this.name = name;
        this.region = region;
        this.menuList = menuList;
    }

    //메뉴 업데이트의 책임을 스스로에게.
    //menuList는 Restaurant에 종속적이기 때문에 갈아껴주면 자동으로 원래 있던 녀석들은 지워준다.
    public void updateMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

}
