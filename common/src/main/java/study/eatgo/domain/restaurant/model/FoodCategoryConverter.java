package study.eatgo.domain.restaurant.model;

import org.springframework.core.convert.converter.Converter;

public class FoodCategoryConverter implements Converter<String, FoodCategory> {

    @Override
    public FoodCategory convert(String code) {
        return FoodCategory.fromCode(Integer.valueOf(code));
    }
}
