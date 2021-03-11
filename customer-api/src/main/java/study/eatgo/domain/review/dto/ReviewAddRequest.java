package study.eatgo.domain.review.dto;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.restaurant.domain.Restaurant;
import study.eatgo.domain.review.domain.Review;

@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
public class ReviewAddRequest {

    @Valid
    @NotEmpty
    private String username;

    @Valid
    @Min(0)
    @Max(5)
    @NotNull
    private Integer score;

    private String content;

    public Review toEntity(Restaurant restaurant) {
        return Review.builder()
            .username(username)
            .score(score)
            .content(content)
            .restaurant(restaurant)
            .build();
    }

}
