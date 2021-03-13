package study.eatgo.jwt.argumentresolver;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import java.security.acl.NotOwnerException;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import study.eatgo.annotations.Member;
import study.eatgo.annotations.Owner;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.user.dao.UserRepository;
import study.eatgo.domain.user.domain.User;
import study.eatgo.jwt.JwtConfig;
import study.eatgo.jwt.JwtTokenProvider;
import study.eatgo.jwt.exception.NoAuthorizationException;

@RequiredArgsConstructor
public class JwtToOwnerArgumentResolver implements HandlerMethodArgumentResolver {

    private final JwtTokenProvider jwtTokenProvider;

    private final UserRepository userRepository;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Owner.class);
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

        return getOwnerFromJwtToken(jwtToken);

    }

    private User getOwnerFromJwtToken(String jwtToken) {
        final Claims claims = jwtTokenProvider.getClaims(jwtToken);
        final Long userId = Long.parseLong(claims.get("userId").toString());

        final User user = userRepository.findById(userId)
            .orElseThrow(() -> new JwtException("Jwt Exception 헤더에 포함된 ID와 매칭되는 유저 없음"));

        if (!user.isOwner()) {
            throw new RestaurantNotFoundException();
        }
        return user;
    }

}
