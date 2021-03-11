package study.eatgo.domain.user.exception;

public class EmailAlreadyExistException extends RuntimeException{

    public EmailAlreadyExistException() {
        super("이미 존재하는 이메일입니다");
    }

}
