package study.eatgo.domain.review.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.eatgo.domain.review.domain.Review;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReviewResponse {

    private List<Review> reviews;

    public ReviewResponse(final List<Review> reviews) {
        this.reviews = reviews;
    }
}
