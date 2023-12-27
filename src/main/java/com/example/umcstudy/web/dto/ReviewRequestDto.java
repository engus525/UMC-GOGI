package com.example.umcstudy.web.dto;

import java.util.List;
import lombok.Getter;

public class ReviewRequestDto {

    @Getter
    public static class WriteDto {
        String body;
        Float score;
        //todo 일단 string으로
        List<String> image;
        Long memberId;
    }
}
