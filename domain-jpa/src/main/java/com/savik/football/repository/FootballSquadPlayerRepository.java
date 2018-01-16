package com.savik.football.repository;

import com.savik.football.model.FootballSquadPlayeer;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FootballSquadPlayerRepository extends JpaEntryRepository<FootballSquadPlayeer> {

    FootballSquadPlayeer findByMyscoreCode(String code);
}
