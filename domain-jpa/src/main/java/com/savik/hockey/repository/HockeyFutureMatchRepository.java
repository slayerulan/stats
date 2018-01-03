package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.repository.JpaEntryRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Repository
public interface HockeyFutureMatchRepository extends JpaEntryRepository<HockeyFutureMatch> {
    HockeyFutureMatch findByMyscoreCode(String code);

    @Modifying
    @Transactional
    void deleteByDateBefore(LocalDateTime expiryDate);

}
