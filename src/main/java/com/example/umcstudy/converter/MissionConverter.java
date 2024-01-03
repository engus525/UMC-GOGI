package com.example.umcstudy.converter;

import com.example.umcstudy.domain.Mission;
import com.example.umcstudy.web.dto.MissionResponseDto;
import com.example.umcstudy.web.dto.MissionResponseDto.MissionDto;
import com.example.umcstudy.web.dto.MissionResponseDto.MissionListDto;
import java.util.List;

public class MissionConverter {

    public static MissionResponseDto.MissionListDto toMissionListDto(List<Mission> missionList) {
        List<MissionDto> missionDtoList = missionList.stream()
            .map(mission -> MissionDto.builder()
                .reward(mission.getReward())
                .storeName(mission.getStore().getName())
                .missionSpec(mission.getMissionSpec())
                .build()).toList();

        return MissionListDto.builder()
            .missionDtoList(missionDtoList)
            .build();
    }
}
