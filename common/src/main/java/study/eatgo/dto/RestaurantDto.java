package study.eatgo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.eatgo.enumer.FoodCategory;
import study.eatgo.enumer.Region;

public class RestaurantDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request {

        @NotEmpty
        private String name;

        @NotEmpty
        private String address;

        @NotEmpty
        private String information;

        @NotNull
        private Region region;

        @NotNull
        private FoodCategory foodCategory;

    }

    //기본 레스토랑 response dto
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Response {

        private Integer id;
        private String name;
        private String address;
        private String information;
        private Region region;
        private FoodCategory foodCategory;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class DetailResponse {

        private Response restaurant;
        private List<MenuItemDto.Response> menuItems;

        @JsonInclude(Include.NON_EMPTY)
        private List<ReviewDto.Response> reviews;
    }
}
