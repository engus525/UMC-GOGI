package com.example.umcstudy.web.controller;

import com.example.umcstudy.converter.ReviewConverter;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.payload.ApiResponse;
import com.example.umcstudy.service.ReviewCommandService;
import com.example.umcstudy.web.dto.ReviewRequestDto;
import com.example.umcstudy.web.dto.ReviewResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/review/w")
    public ApiResponse<ReviewResponseDto.WriteResultDto> write(@RequestBody ReviewRequestDto.WriteDto writeDto, @PathVariable Long storeId) {
        Review review = reviewCommandService.writeReview(writeDto, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDto(review));
    }
}
