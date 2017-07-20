package com.savik.football.repository;

import com.savik.football.model.FootballGoal;
import org.springframework.stereotype.Repository;
import com.savik.repository.JpaEntryRepository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballGoalRepository extends JpaEntryRepository<FootballGoal> {
}