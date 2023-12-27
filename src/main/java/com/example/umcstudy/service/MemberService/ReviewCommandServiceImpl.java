package com.example.umcstudy.service.MemberService;

import com.example.umcstudy.converter.ReviewConverter;
import com.example.umcstudy.converter.ReviewImageConverter;
import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.ReviewImage;
import com.example.umcstudy.domain.Store;
import com.example.umcstudy.payload.code.exception.handler.MemberHandler;
import com.example.umcstudy.payload.code.exception.handler.StoreHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.MemberRepository;
import com.example.umcstudy.repository.ReviewImageRepository;
import com.example.umcstudy.repository.StoreRepository;
import com.example.umcstudy.service.ReviewCommandService;
import com.example.umcstudy.web.dto.ReviewRequestDto;
import com.example.umcstudy.web.dto.ReviewRequestDto.WriteDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewImageRepository reviewImageRepository;

    @Override
    public Review writeReview(ReviewRequestDto.WriteDto writeDto, Long storeId) {
        Member member = memberRepository.findById(writeDto.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Review review = ReviewConverter.toReview(writeDto, member, store);
        setReviewImageList(writeDto, review);

        return review;
    }

    private void setReviewImageList(WriteDto writeDto, Review review) {
        List<ReviewImage> reviewImageList = ReviewImageConverter.toReviewImageList(review, writeDto.getImage());

        reviewImageRepository.saveAll(reviewImageList);
    }
}
