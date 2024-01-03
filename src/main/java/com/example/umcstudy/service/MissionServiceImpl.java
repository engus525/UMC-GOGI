package com.example.umcstudy.service;

import com.example.umcstudy.domain.Mission;
import com.example.umcstudy.domain.enums.MissionStatus;
import com.example.umcstudy.domain.mapping.MemberMission;
import com.example.umcstudy.repository.MemberMissionRepository;
import com.example.umcstudy.repository.MissionRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    public List<Mission> findAllByStoreId(Long storeId) {
        return missionRepository.findAllByStoreId(storeId);
    }

    @Override
    public List<Mission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status) {
        return missionRepository.findAllByMemberIdAndStatus(memberId, status);
    }

    @Override
    public void changeStatus(Long missionId, Long memberId) {
        //todo 이미 com
        MemberMission memberMission = memberMissionRepository.findByMissionIdAndMemberId(missionId, memberId);
        memberMission = memberMission.toBuilder()
            .status(MissionStatus.COMPLETE)
            .build();
        memberMissionRepository.save(memberMission);
    }
}
