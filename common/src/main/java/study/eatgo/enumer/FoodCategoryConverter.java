package study.eatgo.enumer;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class FoodCategoryConverter implements AttributeConverter<FoodCategory, Integer> {

    @Override
    public Integer convertToDatabaseColumn(FoodCategory foodCategory) {
        return foodCategory.getCode();
    }

    @Override
    public FoodCategory convertToEntityAttribute(Integer code) {
        return FoodCategory.fromCode(code);
    }
}
