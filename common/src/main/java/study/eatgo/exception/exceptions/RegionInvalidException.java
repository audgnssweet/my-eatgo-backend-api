package study.eatgo.exception.exceptions;

public class RegionInvalidException extends RuntimeException{

    public RegionInvalidException(Integer regionCode){
        super(regionCode + "는 없는 지역입니다.");
    }
}
