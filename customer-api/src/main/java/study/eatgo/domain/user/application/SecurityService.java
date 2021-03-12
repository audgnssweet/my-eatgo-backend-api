package study.eatgo.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.user.dao.UserRepository;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.dto.AuthenticationRequest;
import study.eatgo.domain.user.exception.EmailNotFoundException;
import study.eatgo.domain.user.exception.PasswordNotMatchException;
import study.eatgo.jwt.JwtTokenProvider;

@Transactional
@RequiredArgsConstructor
@Service
public class SecurityService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public String authenticate(AuthenticationRequest dto) {

        final User user = userRepository.findByEmail(dto.getEmail())
            .orElseThrow(EmailNotFoundException::new);

        final String encoded = passwordEncoder.encode(dto.getPassword());

        if (user.checkPassword(encoded)) {
            throw new PasswordNotMatchException();
        }

        return jwtUtil.createToken(user);
    }

}
