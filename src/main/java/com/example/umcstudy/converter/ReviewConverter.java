package com.example.umcstudy.converter;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.Store;
import com.example.umcstudy.service.MemberService.MemberQueryService;
import com.example.umcstudy.service.StoreQueryService;
import com.example.umcstudy.web.dto.ReviewRequestDto;
import com.example.umcstudy.web.dto.ReviewResponseDto;
import com.example.umcstudy.web.dto.ReviewResponseDto.WriteResultDto;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDto.WriteDto writeDto, Member member, Store store) {

        return Review.builder()
            .body(writeDto.getBody())
            .score(writeDto.getScore())
            .member(member)
            .store(store)
            .build();
    }

    public static ReviewResponseDto.WriteResultDto toWriteResultDto(Review review) {
        return WriteResultDto.builder()
            .id(review.getId())
            .build();
    }
}
