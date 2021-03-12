package study.eatgo.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import study.eatgo.domain.user.domain.User;

public class JwtTokenProvider {

    private final Key key;

    //secret key 만들기.
    public JwtTokenProvider(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    //Token 만들기
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

    //TODO: 긴 토큰 발급 필요.

    //유효성 & 만료일자  확인
    public boolean verifyToken(String jwtToken) throws JwtException{
        try {
            final Claims claims = getClaims(jwtToken);
            return !claims.getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            throw new JwtException("토큰 기간이 만료되었습니다");
        }
    }

    //payload 정보 얻어오기
    public Claims getClaims(String jwtToken) throws JwtException{
        try {
            return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody();
        } catch (MalformedJwtException e) {
            throw new JwtException("토큰이 올바르지 않습니다");
        }
    }

}
