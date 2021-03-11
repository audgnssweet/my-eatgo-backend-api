package study.eatgo.domain.user.exception;

public class PasswordNotMatchException extends RuntimeException{

    public PasswordNotMatchException() {
        super("패스워드가 일치하지 않습니다");
    }
}
