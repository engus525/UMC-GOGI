package com.example.umcstudy.web.dto;

import com.example.umcstudy.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;

public class MemberRequestDto {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        Integer sex;
//        @NotNull
//        Integer birthYear;
//        @NotNull
//        Integer birthMonth;
//        @NotNull
//        Integer birthDay;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }

}
