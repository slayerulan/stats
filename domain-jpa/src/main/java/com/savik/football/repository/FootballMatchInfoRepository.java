package com.savik.football.repository;

import com.savik.football.model.FootballMatchInfo;
import com.savik.football.model.FootballMatchInfo;
import org.springframework.stereotype.Repository;
import com.savik.repository.JpaEntryRepository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballMatchInfoRepository extends JpaEntryRepository<FootballMatchInfo> {
}