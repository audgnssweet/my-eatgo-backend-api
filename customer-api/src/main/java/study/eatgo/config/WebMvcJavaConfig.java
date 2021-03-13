package study.eatgo.config;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import study.eatgo.aop.argumentresolver.JwtToUserArgumentResolver;
import study.eatgo.domain.user.dao.UserRepository;
import study.eatgo.jwt.JwtTokenProvider;

@RequiredArgsConstructor
@Configuration
public class WebMvcJavaConfig implements WebMvcConfigurer {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new JwtToUserArgumentResolver(jwtTokenProvider, userRepository));
    }
}
