package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyMatchInfo;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface HockeyMatchInfoRepository extends JpaEntryRepository<HockeyMatchInfo> {
}
