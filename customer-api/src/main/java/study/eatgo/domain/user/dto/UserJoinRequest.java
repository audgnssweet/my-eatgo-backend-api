package study.eatgo.domain.user.dto;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.model.Email;
import study.eatgo.domain.user.model.Name;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class UserJoinRequest {

    @Valid
    private Email email;

    @Valid
    private Name name;

    @Valid
    @Size(min = 4)
    private String password;

    public User toEntity() {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        return User.builder()
            .email(email)
            .name(name)
            .password(encoder.encode(password))
            .build();
    }

}
