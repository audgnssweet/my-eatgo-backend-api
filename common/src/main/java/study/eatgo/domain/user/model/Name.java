package study.eatgo.domain.user.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(of = {})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Name {

    @NotEmpty   //문자열은 NotEmpty 걸어주는 것이 좋음. Null이아니라 빈 문자열로 들어올 수도 있기 때문에.
    @Column(name = "first_name", length = 50, nullable = false, updatable = false)
    private String first;

    @NotEmpty
    @Column(name = "last_name", length = 50, nullable = false, updatable = false)
    private String last;

    public String getFullName() {
        return String.format("%s %s", first, last);
    }

}
