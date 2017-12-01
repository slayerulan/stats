package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyGoal;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface HockeyGoalRepository extends JpaEntryRepository<HockeyGoal> {
}
