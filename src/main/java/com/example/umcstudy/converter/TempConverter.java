package com.example.umcstudy.converter;

import com.example.umcstudy.web.dto.TempResponse;

public class TempConverter {

    public static TempResponse.TempTestDTO toTempTestDTO() {
        return TempResponse.TempTestDTO.builder()
            .testString("김두현 성공해버렸다.")
            .build();
    }

    public static TempResponse.TempExceptionDTO toTempExceptionDTO(Integer flag) {
        return TempResponse.TempExceptionDTO.builder()
            .flag(flag)
            .build();
    }
}
