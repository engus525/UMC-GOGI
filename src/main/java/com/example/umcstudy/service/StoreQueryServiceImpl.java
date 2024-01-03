package com.example.umcstudy.service;

import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.Store;
import com.example.umcstudy.payload.code.exception.handler.StoreHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.ReviewRepository;
import com.example.umcstudy.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;


    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

    @Override
    public boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }


    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
