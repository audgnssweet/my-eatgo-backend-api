package study.eatgo.application;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.eatgo.domain.Restaurant;
import study.eatgo.domain.RestaurantRepository;
import study.eatgo.dto.MenuItemDto;
import study.eatgo.dto.RestaurantDto;
import study.eatgo.dto.ReviewDto;
import study.eatgo.enumer.FoodCategory;
import study.eatgo.enumer.Region;
import study.eatgo.exception.exceptions.RestaurantNotFoundException;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    @Transactional(readOnly = true)
    public List<RestaurantDto.Response> getRestaurantsByRegionAndFoodCategory(Integer regionId, Integer foodCategoryId) {
        final Region region = Region.fromCode(regionId);
        final FoodCategory foodCategory = FoodCategory.fromCode(foodCategoryId);
        return restaurantRepository.findAllByRegionAndFoodCategory(region, foodCategory).stream()
            .map(this::makeRestaurantResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public RestaurantDto.DetailResponse getRestaurantById(Integer restaurantId) {
        final Restaurant foundRestaurant = restaurantRepository.findById(restaurantId)
            .orElseThrow(RestaurantNotFoundException::new);

        // 레스토랑디테일, 메뉴, 리뷰 따로 만들어서 넣어주기
        final RestaurantDto.Response restaurant = makeRestaurantResponseDto(foundRestaurant);

        List<MenuItemDto.Response> menuItems = makeMenuItemResponseDtoList(foundRestaurant);

        List<ReviewDto.Response> reviews = makeReviewResponseDtoList(foundRestaurant);

        return makeRestaurantDetailDto(restaurant, menuItems, reviews);
    }

    private RestaurantDto.DetailResponse makeRestaurantDetailDto(
        RestaurantDto.Response restaurant,
        List<MenuItemDto.Response> menuItems,
        List<ReviewDto.Response> reviews
    ) {
        return RestaurantDto.DetailResponse.builder()
            .restaurant(restaurant)
            .menuItems(menuItems)
            .reviews(reviews)
            .build();
    }

    private List<ReviewDto.Response> makeReviewResponseDtoList(Restaurant foundRestaurant) {
        return foundRestaurant.getReviews().stream().map(review -> {
            return ReviewDto.Response.builder()
                .id(review.getId())
                .username(review.getUsername())
                .score(review.getScore())
                .content(review.getContent())
                .restaurantId(foundRestaurant.getId())
                .build();
        }).collect(Collectors.toList());
    }

    private List<MenuItemDto.Response> makeMenuItemResponseDtoList(Restaurant foundRestaurant) {
        return foundRestaurant.getMenuItems().stream().map(menuItem -> {
            return MenuItemDto.Response.builder()
                .menuName(menuItem.getName())
                .restaurantId(menuItem.getId())
                .build();
        }).collect(Collectors.toList());
    }

    private RestaurantDto.Response makeRestaurantResponseDto(Restaurant foundRestaurant) {
        return RestaurantDto.Response.builder()
            .id(foundRestaurant.getId())
            .name(foundRestaurant.getName())
            .address(foundRestaurant.getAddress())
            .information(foundRestaurant.getInformation())
            .region(foundRestaurant.getRegion())
            .foodCategory(foundRestaurant.getFoodCategory())
            .build();
    }

}