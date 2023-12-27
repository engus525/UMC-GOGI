package com.example.umcstudy.service.MemberService;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.web.dto.MemberRequestDto;

public interface MemberCommandService {

    Member joinMember(MemberRequestDto.JoinDto request);
}
