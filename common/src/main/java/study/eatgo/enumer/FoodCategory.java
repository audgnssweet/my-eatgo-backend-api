package study.eatgo.enumer;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.eatgo.exception.exceptions.FoodCategoryInvalidException;

@AllArgsConstructor
public enum FoodCategory {
    KOREAN(0, "한식"),
    CHINESE(1, "중식"),
    WESTERN(2, "양식"),
    JAPANESE(3, "일식");

    @Getter
    private final Integer code;
    private final String name;

    private static final Map<Integer, FoodCategory> codeToEnum =
        Stream.of(values()).collect(toMap(FoodCategory::getCode, e -> e));

    public static FoodCategory fromCode(Integer code) {
        FoodCategory foodCategory = codeToEnum.get(code);
        if (Objects.isNull(foodCategory)) {
            throw new FoodCategoryInvalidException(code);
        }
        return foodCategory;
    }
}
