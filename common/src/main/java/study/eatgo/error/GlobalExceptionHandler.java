package study.eatgo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.eatgo.domain.restaurant.exception.FoodCategoryInvalidException;
import study.eatgo.domain.restaurant.exception.RegionInvalidException;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.review.exception.ReviewNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //TODO: 비즈니스에러는 묶어서 처리할 것
    //TODO: 에러는 주석으로 구체적 상황 명시해주는 것이 좋음.

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body("요청 변수가 잘못되었습니다");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleRestaurantNotFoundException(RestaurantNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReviewNotFoundException.class)
    public String handleReviewNotFoundException(ReviewNotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegionInvalidException.class)
    public String HandleRegionInvalidException(RegionInvalidException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FoodCategoryInvalidException.class)
    public String HandleFoodCategoryInvalidException(FoodCategoryInvalidException e) {
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String HandleAllException(Exception e) {
        //로그 출력
        e.printStackTrace();
        return "{기타에러 발생}";
    }

}
