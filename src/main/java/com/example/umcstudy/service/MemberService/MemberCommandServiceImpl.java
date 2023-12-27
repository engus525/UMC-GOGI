package com.example.umcstudy.service.MemberService;

import com.example.umcstudy.converter.MemberConverter;
import com.example.umcstudy.converter.MemberPreferConverter;
import com.example.umcstudy.domain.FoodCategory;
import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.mapping.MemberPrefer;
import com.example.umcstudy.payload.code.exception.handler.FoodCategoryHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.repository.FoodCategoryRepository;
import com.example.umcstudy.repository.MemberPreferRepository;
import com.example.umcstudy.repository.MemberRepository;
import com.example.umcstudy.web.dto.MemberRequestDto;
import com.example.umcstudy.web.dto.MemberRequestDto.JoinDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberPreferRepository memberPreferRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDto.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        setMemberPreferList(request, member);

        return memberRepository.save(member);
    }

    private void setMemberPreferList(JoinDto request, Member member) {
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
            .map(category -> foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).toList();
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(member, foodCategoryList);

        memberPreferRepository.saveAll(memberPreferList);
    }
}