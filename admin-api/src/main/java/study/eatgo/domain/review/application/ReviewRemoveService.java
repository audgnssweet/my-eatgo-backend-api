package study.eatgo.domain.review.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.restaurant.exception.RestaurantNotFoundException;
import study.eatgo.domain.review.dao.ReviewDeleteRepository;
import study.eatgo.domain.review.dao.ReviewRepository;
import study.eatgo.domain.user.domain.User;

/*
해당 클래스 기능 : 레스토랑 탈퇴시.
레스토랑 탈퇴시 모든 리뷰를 지워야하기 때문에.
 */
@RequiredArgsConstructor
@Transactional
@Service
public class ReviewRemoveService {

    private final ReviewDeleteRepository reviewDeleteRepository;

    public void removeAllInRestaurant(User user) {
        if (!user.isOwner()) {
            throw new RestaurantNotFoundException();
        }
        reviewDeleteRepository.removeAllByRestaurantId(user.getRestaurant().getId());
    }
}
