package com.savik.football.repository;

import com.savik.football.model.FootballSquadPlayer;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FootballSquadPlayerRepository extends JpaEntryRepository<FootballSquadPlayer> {

    FootballSquadPlayer findByMyscoreCode(String code);
}
