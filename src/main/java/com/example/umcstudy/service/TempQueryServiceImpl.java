package com.example.umcstudy.service;

import com.example.umcstudy.payload.code.exception.handler.TempHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1) {
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }
    }
}
