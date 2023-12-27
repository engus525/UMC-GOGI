package com.example.umcstudy.payload.code.exception.handler;

import com.example.umcstudy.payload.code.BaseErrorCode;
import com.example.umcstudy.payload.code.exception.GeneralException;

public class MemberHandler extends GeneralException {

    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
