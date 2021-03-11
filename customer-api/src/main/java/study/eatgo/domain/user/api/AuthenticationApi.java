package study.eatgo.domain.user.api;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.eatgo.domain.user.application.SecurityService;
import study.eatgo.domain.user.dto.AuthenticationRequest;

@RequiredArgsConstructor
@RestController
public class AuthenticationApi {

    private final SecurityService securityService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody @Valid AuthenticationRequest dto) {
        return securityService.authenticate(dto);
    }

}
