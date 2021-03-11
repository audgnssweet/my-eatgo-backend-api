package study.eatgo.error.exceptions;

public class MenuNotFoundException extends RuntimeException{

    public MenuNotFoundException() {
        super("해당 id의 메뉴는 없습니다");
    }
}
