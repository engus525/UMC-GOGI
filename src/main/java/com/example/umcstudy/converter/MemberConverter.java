package com.example.umcstudy.converter;

import com.example.umcstudy.domain.Member;
import com.example.umcstudy.domain.enums.Sex;
import com.example.umcstudy.payload.code.exception.handler.MemberJoinHandler;
import com.example.umcstudy.payload.code.status.ErrorStatus;
import com.example.umcstudy.web.dto.MemberRequestDto;
import com.example.umcstudy.web.dto.MemberRequestDto.JoinDto;
import com.example.umcstudy.web.dto.MemberResponseDto;
import java.sql.Timestamp;
import java.util.ArrayList;


public class MemberConverter {

    public static MemberResponseDto.JoinResultDto toJoinResultDTO(Member member) {
        return MemberResponseDto.JoinResultDto.builder()
            .memberId(member.getId())
            .createdAt(new Timestamp(System.currentTimeMillis()))
            .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request) {
        Sex sex = getSex(request);
        String address = getAddress(request);
        String specAddress = getSpecAddress(request);
        String name = getName(request);

        return Member.builder()
            .address(address)
            .specAddress(specAddress)
            .sex(sex)
            .name(name)
            .memberPreferList(new ArrayList<>())
            .build();
    }

    private static String getName(JoinDto request) {
        if (!request.getName().equals("")) {
            return request.getName();
        } else {
            throw new MemberJoinHandler(ErrorStatus.NAME_NOT_EXIST);
        }
    }

    private static String getAddress(JoinDto request) {
        if (satisfyAddressLength(request.getAddress())) {
            return request.getAddress();
        } else {
            throw new MemberJoinHandler(ErrorStatus.ADDRESS_LENGTH_NOT_SATISFIED);
        }
    }

    private static String getSpecAddress(JoinDto request) {
        if (satisfyAddressLength(request.getAddress())) {
            return request.getSpecAddress();
        } else {
            throw new MemberJoinHandler(ErrorStatus.SPEC_ADDRESS_LENGTH_NOT_SATISFIED);
        }
    }

    private static boolean satisfyAddressLength(String address) {
        return 5 <= address.length() && address.length() <= 12;
    }

    private static Sex getSex(JoinDto request) {
        return switch (request.getSex()) {
            case 1 -> Sex.MALE;
            case 2 -> Sex.FEMALE;
            default -> throw new MemberJoinHandler(ErrorStatus.SEX_NOT_EXIST);
        };
    }
}
