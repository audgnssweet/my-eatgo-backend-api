package study.eatgo.domain.user.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.model.Email;
import study.eatgo.domain.user.model.Name;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserResponse {

    private Email email;

    private Name name;

    public UserResponse(final User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }

}
