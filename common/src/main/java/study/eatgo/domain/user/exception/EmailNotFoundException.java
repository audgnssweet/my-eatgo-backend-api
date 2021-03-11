package study.eatgo.domain.user.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super("해당 이메일은 존재하지 않습니다.");
    }
}
