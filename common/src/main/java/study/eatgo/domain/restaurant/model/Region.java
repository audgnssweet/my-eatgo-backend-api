package study.eatgo.domain.restaurant.model;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.eatgo.error.exceptions.RegionInvalidException;

@AllArgsConstructor
public enum Region {
    SEOUL(0),
    BUSAN(1);

    @Getter
    private final Integer code;

    private static final Map<Integer, Region> codeToRegion =
        Stream.of(values()).collect(toMap(Region::getCode, e -> e));

    public static Region fromCode(Integer code) {
        Region region = codeToRegion.get(code);
        if (Objects.isNull(region)) {
            throw new RegionInvalidException(code);
        }
        return region;
    }

}
