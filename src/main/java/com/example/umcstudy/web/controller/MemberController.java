package com.example.umcstudy.web.controller;

import com.example.umcstudy.converter.MemberConverter;
import com.example.umcstudy.domain.Member;
import com.example.umcstudy.payload.ApiResponse;
import com.example.umcstudy.service.MemberService.MemberCommandService;
import com.example.umcstudy.web.dto.MemberRequestDto;
import com.example.umcstudy.web.dto.MemberResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberCommandService memberCommandService;

    @PostMapping
    public ApiResponse<MemberResponseDto.JoinResultDto> join(@RequestBody @Valid MemberRequestDto.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
