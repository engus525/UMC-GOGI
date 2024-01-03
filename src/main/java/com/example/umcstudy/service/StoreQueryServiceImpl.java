package com.example.umcstudy.service;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.Store;
import com.example.umcstudy.payload.code.exception.handler.StoreHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.MemberRepository;
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
    private final MemberRepository memberRepository;


    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }

    @Override
    public boolean existsById(Long id) {
        return storeRepository.existsById(id);
    }


    @Override
    public Page<Review> getReviewList(Long storeId, Integer page, Long memberId) {
        Store store = storeRepository.findById(storeId).get();

        if (memberId != null) {
            Member member = memberRepository.findById(memberId).get();
            return reviewRepository.findAllByStoreAndMember(store, member, PageRequest.of(page, 10));
        }

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
