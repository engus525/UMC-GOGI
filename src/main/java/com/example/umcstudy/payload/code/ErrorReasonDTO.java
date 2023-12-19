package com.example.umcstudy.payload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Getter
public class ErrorReasonDTO {
    private HttpStatus httpStatus;
    private final Boolean isSuccess;
    private final String code;
    private final String  message;
}
