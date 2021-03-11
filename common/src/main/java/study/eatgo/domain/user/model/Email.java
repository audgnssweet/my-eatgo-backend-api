package study.eatgo.domain.user.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Embeddable
@ToString(of = {"value"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Email {

    @javax.validation.constraints.Email     //제약조건도 필수적으로 달아주면 좋음.
    @NotEmpty
    @Column(name = "email", length = 50)    //이렇게 달아줘야함
    private String value;

    public String getUsername() {
        final int index = value.indexOf('@');
        return value.substring(0, index);
    }

    public String getHost() {
        final int index = value.indexOf('@');
        return value.substring(index + 1);
    }

}
