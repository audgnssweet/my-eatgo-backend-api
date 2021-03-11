package study.eatgo.domain.user.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.user.application.UserService;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.dto.UserJoinRequest;
import study.eatgo.domain.user.dto.UserResponse;

@RequiredArgsConstructor
@RestController
public class UserApi {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponse join(@RequestBody @Valid UserJoinRequest dto) {
        final User user = userService.join(dto);
        return new UserResponse(user);
    }

}
