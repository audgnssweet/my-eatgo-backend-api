package study.eatgo.domain.user.dto;

import javax.validation.Valid;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.user.model.Email;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class AuthenticationRequest {

    @Valid
    private Email email;

    @Valid
    private String password;

}
