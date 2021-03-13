package study.eatgo.aop.argumentresolver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.eatgo.annotations.Member;
import study.eatgo.domain.user.dao.UserRepository;
import study.eatgo.domain.user.domain.User;
import study.eatgo.jwt.JwtConfig;
import study.eatgo.jwt.JwtTokenProvider;
import study.eatgo.jwt.exception.NoAuthorizationException;

@RequiredArgsConstructor
public class JwtToUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Member.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        //헤더에서 토큰 얻어오기
        final String token = webRequest.getHeader(JwtConfig.HEADER);

        //기본체크
        if (Objects.isNull(token) || !token.startsWith(JwtConfig.TOKEN_PREFIX)) {
            throw new NoAuthorizationException();
        }
        final String jwtToken = token.replace(JwtConfig.TOKEN_PREFIX, "");


        //validation check
        jwtTokenProvider.verifyToken(jwtToken);

        return getUserFromJwtToken(jwtToken);

    }

    private User getUserFromJwtToken(String jwtToken) {
        final Claims claims = jwtTokenProvider.getClaims(jwtToken);
        final Long userId = Long.parseLong(claims.get("userId").toString());

        return userRepository.findById(userId)
            .orElseThrow(() -> new JwtException("Jwt Exception 헤더에 포함된 ID와 매칭되는 유저 없음"));
    }

}
