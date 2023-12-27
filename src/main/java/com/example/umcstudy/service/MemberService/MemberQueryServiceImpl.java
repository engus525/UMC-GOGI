package com.example.umcstudy.service.MemberService;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.payload.code.exception.handler.MemberHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
