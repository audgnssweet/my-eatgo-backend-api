package study.eatgo.enumer;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Role {

    USER(0),
    RESTAURANT_OWNER(1),
    ADMIN(2);

    @Getter
    private final Integer code;

}
