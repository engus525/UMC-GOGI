package com.example.umcstudy.repository;

import com.example.umcstudy.domain.mapping.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    MemberMission findByMissionIdAndMemberId(Long missionId, Long memberId);
}
