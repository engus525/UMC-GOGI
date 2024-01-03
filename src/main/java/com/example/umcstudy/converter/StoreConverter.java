package com.example.umcstudy.converter;

import com.example.umcstudy.domain.Review;
import com.example.umcstudy.web.dto.StoreRequestDto;
import com.example.umcstudy.web.dto.StoreResponseDto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;

public class StoreConverter {

    public static Review toReview(StoreRequestDto.ReviewDTO request){
        return Review.builder()
            .title(request.getTitle())
            .score(request.getScore())
            .body(request.getBody())
            .build();
    }

    public static StoreResponseDto.CreateReviewResultDto toCreateReviewResultDTO(Review review){
        return StoreResponseDto.CreateReviewResultDto.builder()
            .reviewId(review.getId())
            .createdAt(LocalDateTime.now())
            .build();
    }

    public static StoreResponseDto.ReviewPreViewDto reviewPreViewDto(Review review){
        return StoreResponseDto.ReviewPreViewDto.builder()
            .ownerNickname(review.getMember().getName())
            .score(review.getScore())
            .createdAt(review.getCreatedAt().toLocalDate())
            .body(review.getBody())
            .build();
    }

    public static StoreResponseDto.ReviewPreViewListDto reviewPreViewListDto(Page<Review> reviewList){

        List<StoreResponseDto.ReviewPreViewDto> reviewPreViewDtoList = reviewList.stream()
            .map(StoreConverter::reviewPreViewDto).collect(Collectors.toList());

        return StoreResponseDto.ReviewPreViewListDto.builder()
            .isLast(reviewList.isLast())
            .isFirst(reviewList.isFirst())
            .totalPage(reviewList.getTotalPages())
            .totalElements(reviewList.getTotalElements())
            .listSize(reviewPreViewDtoList.size())
            .reviewList(reviewPreViewDtoList)
            .build();
    }
}