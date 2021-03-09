package study.eatgo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.eatgo.exception.exceptions.MenuItemNotFoundException;
import study.eatgo.exception.exceptions.RestaurantNotFoundException;
import study.eatgo.exception.exceptions.ReviewNotFoundException;

@RestControllerAdvice
public class RestaurantExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body("요청 변수가 잘못되었습니다");
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleRestaurantNotFoundException(RestaurantNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(MenuItemNotFoundException.class)
    public String handleMenuItemNotFoundException(MenuItemNotFoundException e) {
        return e.getMessage();
    }

    @ExceptionHandler(ReviewNotFoundException.class)
    public String handleReviewNotFoundException(ReviewNotFoundException e) {
        return e.getMessage();
    }
}
