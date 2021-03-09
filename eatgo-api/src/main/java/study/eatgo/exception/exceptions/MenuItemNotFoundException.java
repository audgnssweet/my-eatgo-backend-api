package study.eatgo.exception.exceptions;

public class MenuItemNotFoundException extends RuntimeException{

    public MenuItemNotFoundException() {
        super("해당 id의 메뉴는 없습니다");
    }
}
