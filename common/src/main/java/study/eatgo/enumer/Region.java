package study.eatgo.enumer;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import study.eatgo.exception.exceptions.RegionInvalidException;

@AllArgsConstructor
public enum Region {
    SEOUL(0, "서울"),
    BUSAN(1, "부산");

    @Getter
    private final Integer code;
    private final String description;

    /*
    Map으로 만들어준다. Inte값과 Region을.
    여기서 values()는 Region[]을 return
    Java.util.stream임.
     */
    private static final Map<Integer, Region> codeToEnum =
        Stream.of(values()).collect(toMap(Region::getCode, e -> e));

    /*
    Integer을 받아서 ErrorCheck하고, Region Return 하는 함수를 미리 만들어서
    Converter을 구현할 때 편의성을 둔다.
     */
    public static Region fromCode(Integer code) {
        Region region = codeToEnum.get(code);
        if (Objects.isNull(region)) {
            throw new RegionInvalidException(code);
        }
        return region;
    }

}
