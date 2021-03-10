package study.eatgo.enumer;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.eatgo.exception.exceptions.RegionInvalidException;

@AllArgsConstructor
public enum FoodCategory {
    KOREAN(0),
    CHINESE(1),
    WESTERN(2),
    JAPANESE(3);

    @Getter
    private final Integer code;

    private static final Map<Integer, FoodCategory> codeToFoodCategory =
        Stream.of(values()).collect(toMap(FoodCategory::getCode, e -> e));

    public static FoodCategory fromCode(Integer code) {
        FoodCategory foodCategory = codeToFoodCategory.get(code);
        if (Objects.isNull(foodCategory)) {
            throw new RegionInvalidException(code);
        }
        return foodCategory;
    }
}
