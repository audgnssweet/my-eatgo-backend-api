package study.eatgo.domain.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.eatgo.domain.menu.dto.MenuDto;
import study.eatgo.domain.restaurant.model.FoodCategory;
import study.eatgo.domain.restaurant.model.Region;
import study.eatgo.domain.review.dto.ReviewDto;

public class RestaurantDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request {

        @NotEmpty
        private String name;

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
        private Region region;
        private FoodCategory foodCategory;

    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class DetailResponse {

        private Response restaurant;
        private List<MenuDto.Response> menus;

        @JsonInclude(Include.NON_EMPTY)
        private List<ReviewDto.Response> reviews;
    }
}
