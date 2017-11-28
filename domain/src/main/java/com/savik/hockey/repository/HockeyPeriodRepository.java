package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyPeriod;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface HockeyPeriodRepository extends JpaEntryRepository<HockeyPeriod> {
}
