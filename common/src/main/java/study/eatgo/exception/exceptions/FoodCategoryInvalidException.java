package study.eatgo.exception.exceptions;

public class FoodCategoryInvalidException extends RuntimeException{

    public FoodCategoryInvalidException(Integer foodCategoryCode) {
        super(foodCategoryCode + "는 없는 음식 종류입니다");
    }
}
