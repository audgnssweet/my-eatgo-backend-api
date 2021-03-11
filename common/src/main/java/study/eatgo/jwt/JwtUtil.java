package study.eatgo.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import study.eatgo.config.JwtConfig;
import study.eatgo.domain.user.domain.User;

public class JwtUtil {

    private final Key key;

    //secret key 만들기.
    public JwtUtil(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String createToken(User user) {

        //헤더
        Map<String, Object> headers = new HashMap<>();
        headers.put("typ", JwtConfig.TYPE);
        headers.put("alg", JwtConfig.ALGORITHM);

        //Claims
        Map<String, Object> payloads = new HashMap<>();
        payloads.put("userId", user.getId());
        payloads.put("username", user.getName().getFullName());

        //만료시간설정
        Date exp = new Date(); // 토큰 만료 시간
        exp.setTime(exp.getTime() + JwtConfig.DURATION);

        //JwtToken 만들기.
        String jwtToken = Jwts.builder()
            .setHeader(headers)
            .setClaims(payloads)
            .setExpiration(exp)
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();

        return jwtToken;
    }
}
