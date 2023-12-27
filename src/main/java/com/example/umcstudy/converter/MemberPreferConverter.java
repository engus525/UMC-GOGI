package com.example.umcstudy.converter;

import com.example.umcstudy.domain.FoodCategory;
import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.mapping.MemberPrefer;
import java.util.List;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(Member member, List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
            .map(foodCategory -> MemberPrefer.builder()
                .member(member)
                .foodCategory(foodCategory)
                .build()
            ).toList();
    }
}
