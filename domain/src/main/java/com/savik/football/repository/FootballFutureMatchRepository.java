package com.savik.football.repository;

import com.savik.football.model.FootballFutureMatch;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballFutureMatchRepository extends JpaEntryRepository<FootballFutureMatch> {

}
