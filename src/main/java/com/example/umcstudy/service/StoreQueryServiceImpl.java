package com.example.umcstudy.service;

import com.example.umcstudy.domain.Store;
import com.example.umcstudy.payload.code.exception.handler.StoreHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreQueryServiceImpl implements StoreQueryService{

    private final StoreRepository storeRepository;


    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
    }
}
