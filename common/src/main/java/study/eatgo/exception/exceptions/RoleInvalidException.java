package study.eatgo.exception.exceptions;

public class RoleInvalidException extends RuntimeException{

    public RoleInvalidException(Integer roleCode) {
        super(roleCode + "인 권한은 없습니다");
    }
}
