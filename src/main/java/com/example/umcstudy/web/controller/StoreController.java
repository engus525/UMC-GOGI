package com.example.umcstudy.web.controller;

import com.example.umcstudy.converter.ReviewConverter;
import com.example.umcstudy.converter.StoreConverter;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.payload.ApiResponse;
import com.example.umcstudy.service.ReviewCommandService;
import com.example.umcstudy.service.StoreQueryService;
import com.example.umcstudy.validation.annotation.ExistStore;
import com.example.umcstudy.web.dto.ReviewRequestDto;
import com.example.umcstudy.web.dto.ReviewResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final ReviewCommandService reviewCommandService;
    private final StoreQueryService storeQueryService;

    @PostMapping("/{storeId}/review/w")
    public ApiResponse<ReviewResponseDto.WriteResultDto> write(@RequestBody ReviewRequestDto.WriteDto writeDto, @PathVariable Long storeId) {
        Review review = reviewCommandService.writeReview(writeDto, storeId);
        return ApiResponse.onSuccess(ReviewConverter.toWriteResultDto(review));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게 및 특정 유저의 리뷰 목록 조회 API", description = "특정 가게 및 특정 유저의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양이 이상함", content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
        @Parameter(name = "storeId", description = "가게의 id, path variable 입니다!"),
        @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
        @Parameter(name = "memberId", description = "멤버의 id입니다.")
    })
    public ApiResponse<ReviewResponseDto.ReviewPreViewListDto> getReviewList(@ExistStore @PathVariable(name = "storeId") Long storeId,
        @RequestParam(name = "page") Integer page,
        @RequestParam(name = "memberId", required = false) Long memberId) {
        Page<Review> reviewList = storeQueryService.getReviewList(storeId, page, memberId);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDto(reviewList));
    }
}
