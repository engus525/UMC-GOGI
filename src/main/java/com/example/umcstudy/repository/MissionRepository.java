package com.example.umcstudy.repository;

import com.example.umcstudy.domain.Mission;
import com.example.umcstudy.domain.enums.MissionStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {

    List<Mission> findAllByStoreId(Long storeId);

    @Query("select m from Mission as m join fetch m.memberMissionList as l where l.member.id=:memberId and l.status=:status")
    List<Mission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status);
}
