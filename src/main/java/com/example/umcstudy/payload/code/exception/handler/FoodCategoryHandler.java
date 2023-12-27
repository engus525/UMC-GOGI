package com.example.umcstudy.payload.code.exception.handler;

import com.example.umcstudy.payload.code.BaseErrorCode;
import com.example.umcstudy.payload.code.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
