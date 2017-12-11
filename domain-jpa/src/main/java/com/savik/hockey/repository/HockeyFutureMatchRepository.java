package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HockeyFutureMatchRepository extends JpaEntryRepository<HockeyFutureMatch> {
    HockeyFutureMatch findByMyscoreCode(String code);

}
