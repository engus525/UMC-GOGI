package com.example.umcstudy.repository;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.Review;
import com.example.umcstudy.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByStoreAndMember(Store store, Member member, PageRequest pageRequest);
}
