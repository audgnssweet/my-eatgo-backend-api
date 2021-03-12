package study.eatgo.jwt;

public final class JwtConfig {

    private JwtConfig() {}

    public static final String SECRET = "12345678901234567890123456789012";   //JWT 시크릿키
    public static final Long DURATION =  1000 * 60 * 10L;  //Date기준 6000 - 1초
    public static final String ALGORITHM = "HS256";
    public static final String TYPE = "JWT";
    public static final String HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
