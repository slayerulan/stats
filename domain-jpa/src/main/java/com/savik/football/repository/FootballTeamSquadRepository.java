package com.savik.football.repository;

import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballTeam;
import com.savik.football.model.FootballTeamSquad;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballTeamSquadRepository extends JpaEntryRepository<FootballTeamSquad> {

}
