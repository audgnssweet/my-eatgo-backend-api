package study.eatgo.domain.menu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.eatgo.domain.menu.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
