package com.example.umcstudy.payload.code.exception.handler;

import com.example.umcstudy.payload.code.BaseErrorCode;
import com.example.umcstudy.payload.code.exception.GeneralException;

public class MemberJoinHandler extends GeneralException {

    public MemberJoinHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
