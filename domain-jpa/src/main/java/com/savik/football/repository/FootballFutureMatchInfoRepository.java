package com.savik.football.repository;

import com.savik.football.model.FootballFutureMatchInfo;
import com.savik.repository.JpaEntryRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface FootballFutureMatchInfoRepository extends JpaEntryRepository<FootballFutureMatchInfo> {
    FootballFutureMatchInfo findByMyscoreCode(String code);

    @Modifying
    @Transactional
    void deleteByMyscoreCode(String code);
}
