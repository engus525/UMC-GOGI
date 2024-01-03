package com.example.umcstudy.service;

import com.example.umcstudy.domain.Mission;
import com.example.umcstudy.domain.enums.MissionStatus;
import java.util.List;

public interface MissionService {

    List<Mission> findAllByStoreId(Long storeId);
    List<Mission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status);
    void changeStatus(Long missionId, Long memberId);
}
