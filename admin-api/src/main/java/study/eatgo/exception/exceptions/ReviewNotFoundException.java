package study.eatgo.exception.exceptions;

public class ReviewNotFoundException extends RuntimeException{

    public ReviewNotFoundException() {
        super("해당 id의 리뷰는 존재하지 않습니다");
    }
}
