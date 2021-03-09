package study.eatgo.dto;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class MenuItemDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request {

        private Integer id;
        @NotEmpty   //NotNull과는 다름.
        private String name;
        private boolean delete;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Response {

        private String menuName;
        private Integer restaurantId;
    }

}
