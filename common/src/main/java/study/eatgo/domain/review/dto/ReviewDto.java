package study.eatgo.domain.review.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ReviewDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request {

        @NotEmpty
        @NotNull
        private String username;

        //@Size는 문자열, 배열
        //숫자는 @Min, Max
        @NotNull
        @Max(10)
        @Min(0)
        private Integer score;

        private String content;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Response {

        private Integer id;
        private String username;
        private Integer score;
        private String content;
        private Integer restaurantId;
    }

}
