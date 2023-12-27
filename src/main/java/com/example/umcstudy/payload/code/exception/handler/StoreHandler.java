package com.example.umcstudy.payload.code.exception.handler;

import com.example.umcstudy.payload.code.BaseErrorCode;
import com.example.umcstudy.payload.code.exception.GeneralException;

public class StoreHandler extends GeneralException {

    public StoreHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
