package com.example.umcstudy.payload.code.exception.handler;

import com.example.umcstudy.payload.code.BaseErrorCode;
import com.example.umcstudy.payload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
