package com.example.umcstudy.service;

import com.example.umcstudy.domain.Review;
import com.example.umcstudy.web.dto.ReviewRequestDto;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDto.WriteDto writeDto, Long storeId);
}
