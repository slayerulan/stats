package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyMatch;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HockeyMatchRepository extends JpaEntryRepository<HockeyMatch> {
    public HockeyMatch findByMyscoreCode(String code);
}
