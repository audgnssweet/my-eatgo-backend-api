package study.eatgo.domain.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.user.dao.UserRepository;
import study.eatgo.domain.user.domain.User;
import study.eatgo.domain.user.dto.UserJoinRequest;
import study.eatgo.domain.user.exception.EmailAlreadyExistException;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;

    public User join(UserJoinRequest dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new EmailAlreadyExistException();
        }
        return userRepository.save(dto.toEntity());
    }

}
