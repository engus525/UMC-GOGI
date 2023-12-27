package com.example.umcstudy.converter;

import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.ReviewImage;
import java.util.List;

public class ReviewImageConverter {

    public static List<ReviewImage> toReviewImageList(Review review, List<String> imageList) {
        return imageList.stream()
            .map(image -> ReviewImage.builder()
                //todo getName to S3 url
                .imageUrl(image)
                .review(review)
                .build()
            ).toList();
    }
}
