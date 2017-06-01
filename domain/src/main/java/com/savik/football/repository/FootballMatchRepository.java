package com.savik.football.repository;

import com.savik.football.model.FootballMatch;
import org.springframework.stereotype.Repository;
import com.savik.repository.JpaEntryRepository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballMatchRepository extends JpaEntryRepository<FootballMatch> {
    public FootballMatch findByMyscoreCode(String code);
}
