package com.savik.snooker.repository;

import com.savik.Season;
import com.savik.repository.JpaEntryRepository;
import com.savik.snooker.model.SnookerChampionship;
import com.savik.snooker.model.SnookerMatch;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SnookerMatchRepository extends JpaEntryRepository<SnookerMatch> {
    SnookerMatch findByMyscoreCode(String code);

    List<SnookerMatch> findByChampionship(SnookerChampionship snookerChampionship);

    List<SnookerMatch> findBySeason(Season season);
}
