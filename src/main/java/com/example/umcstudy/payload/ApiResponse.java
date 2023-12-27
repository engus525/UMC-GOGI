package com.example.umcstudy.payload;

import com.example.umcstudy.payload.code.BaseCode;
import com.example.umcstudy.payload.code.status.SuccessStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder
public class ApiResponse<T> {

    //기존 responseEntity는 code, result dto 반환
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;//200 400 500
    private final String message;//요청을 정확히 어떻게 처리했는지
    @JsonInclude(Include.NON_NULL)
    private T result;// result dto


    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result) {
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(), result);

    }


    public static <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, code, message, data);
    }
}
