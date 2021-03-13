package study.eatgo.error;

import io.jsonwebtoken.JwtException;
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
import study.eatgo.domain.user.exception.EmailAlreadyExistException;
import study.eatgo.domain.user.exception.EmailNotFoundException;
import study.eatgo.domain.user.exception.PasswordNotMatchException;
import study.eatgo.jwt.exception.NoAuthorizationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //TODO: 비즈니스에러는 묶어서 처리할 것
    //TODO: 에러는 주석으로 구체적 상황 명시해주는 것이 좋음.

    /*
    Request할 때 Augument가 잘못 되어있을 때 @Valid에서 걸리면 발생하는 에러
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body("요청 변수가 잘못되었습니다");
    }

    /*
    없는 레스토랑에 대한 요청이 들어왔을 때 발생하는 에러
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestaurantNotFoundException.class)
    public String handleRestaurantNotFoundException(RestaurantNotFoundException e) {
        return e.getMessage();
    }

    /*
    없는 리뷰에 대한 요청이 들어왔을 때 발생하는 에러
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReviewNotFoundException.class)
    public String handleReviewNotFoundException(ReviewNotFoundException e) {
        return e.getMessage();
    }

    /*
    없는 지역에 대한 필터링 요청이 들어왔을 때 발생하는 에러
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(RegionInvalidException.class)
    public String HandleRegionInvalidException(RegionInvalidException e) {
        return e.getMessage();
    }

    /*
    없는 음식 카테고리에 대한 요청이 들어왔을 때 발생하는 에러.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(FoodCategoryInvalidException.class)
    public String HandleFoodCategoryInvalidException(FoodCategoryInvalidException e) {
        return e.getMessage();
    }

    /*
    회원가입 시 이메일이 겹쳤을 때 발생하는 에러.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailAlreadyExistException.class)
    public String HandleEmailAlreadyExistException(EmailAlreadyExistException e) {
        return e.getMessage();
    }

    /*
    회원 인증 관련해서 존재하지 않는 이메일로 요청이 들어왔을 경우 발생하는 에러
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(EmailNotFoundException.class)
    public String HandleEmailNotFoundException(EmailNotFoundException e) {
        return e.getMessage();
    }

    /*
    로그인 요청시 패스워드가 일치하지 않을 때 발생하는 에러
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(PasswordNotMatchException.class)
    public String HandlePasswordNotMatchException(PasswordNotMatchException e) {
        return e.getMessage();
    }

    /*
    JWT토큰의 서명을 확인할 때 인증에 실패한 경우
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(JwtException.class)
    public String HandleJwtException(JwtException e) {
        e.printStackTrace();
        return "{Jwt 토큰 관련 에러 발생. 콘솔을 확인하세요}";
    }

    /*
    토큰이 필요한 요청에 토큰이 아예 없이 들어온 경우 Interceptor에서 발생시키는 에러.
     */
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(NoAuthorizationException.class)
    public String HandleNoAuthorizationException(NoAuthorizationException e) {
        return e.getMessage();
    }

    /*
    기타 모든 에러
     */
    @ExceptionHandler(Exception.class)
    public String HandleAllException(Exception e) {
        //로그 출력
        e.printStackTrace();
        return "{기타에러 발생}";
    }

}
