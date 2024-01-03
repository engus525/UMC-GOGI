package com.example.umcstudy.service;

import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.Store;
import org.springframework.data.domain.Page;

public interface StoreQueryService {

    Store findById(Long id);
    boolean existsById(Long id);
    Page<Review> getReviewList(Long storeId, Integer page, Long memberId);
}
