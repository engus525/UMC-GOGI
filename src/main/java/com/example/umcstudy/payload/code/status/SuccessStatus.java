package com.example.umcstudy.payload.code.status;

import com.example.umcstudy.payload.code.BaseCode;
import com.example.umcstudy.payload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "COMMON200", "자네의 요청을 아주 성공적으로 수행했다네. 바로 이 김두현이말이지."),
    _CREATED(HttpStatus.CREATED, "COMMON201", "자네가 원하는 것? 아주 깔쌈하게 생성했다네. 바로 이 김두현이말이지.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
            .httpStatus(httpStatus)
            .code(code)
            .message(message)
            .isSuccess(true)
            .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
            .httpStatus(httpStatus)
            .code(code)
            .message(message)
            .isSuccess(true)
            .build();

    }
}
