package com.example.umcstudy.web.controller;

import com.example.umcstudy.converter.MissionConverter;
import com.example.umcstudy.domain.Mission;
import com.example.umcstudy.domain.enums.MissionStatus;
import com.example.umcstudy.payload.ApiResponse;
import com.example.umcstudy.service.MissionService;
import com.example.umcstudy.validation.annotation.ExistStore;
import com.example.umcstudy.web.dto.MissionResponseDto;
import com.example.umcstudy.web.dto.MissionResponseDto.MissionListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionService missionService;

    @GetMapping("")
    public ApiResponse<MissionResponseDto.MissionListDto> getStoreMissionList(
        @ExistStore @RequestParam(name = "storeId", required = false) Long storeId) {
        List<Mission> missionList = missionService.findAllByStoreId(storeId);
        MissionListDto missionListDto = MissionConverter.toMissionListDto(missionList);

        return ApiResponse.onSuccess(missionListDto);
    }

    @GetMapping("/my-mission")
    public ApiResponse<MissionResponseDto.MissionListDto> getMyMissionList(
        //todo 토큰이 없어서 일단 parameter로 받음
        @RequestParam(name = "memberId") Long memberId,
        @RequestParam(name = "status", required = false) String status
        ) {
        List<Mission> missionList = missionService.findAllByMemberIdAndStatus(memberId, MissionStatus.valueOf(status));
        MissionListDto missionListDto = MissionConverter.toMissionListDto(missionList);

        return ApiResponse.onSuccess(missionListDto);
    }

    @PatchMapping("/my-mission")
    public ApiResponse<Boolean> changeMissionStatus(
        //todo 토큰이 없어서 일단 parameter로 받음
        @RequestParam(name = "missionId", required = false) Long missionId,
        @RequestParam(name = "memberId") Long memberId
    ) {
        missionService.changeStatus(missionId, memberId);

        return ApiResponse.onSuccess(true);
    }

}