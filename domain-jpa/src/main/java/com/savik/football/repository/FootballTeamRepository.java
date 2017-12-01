package com.savik.football.repository;

import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballChampionship;
import com.savik.football.model.FootballTeam;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballTeamRepository extends JpaEntryRepository<FootballTeam> {

    FootballTeam findOneByNameAndChampionship_(String name, FootballChampionship footballChampionship);

    default FootballTeam findOneByNameAndChampionship(String name, FootballChampionship championship) {
        FootballTeam footballTeam = findOneByNameAndChampionship_(name, championship);
        if (footballTeam == null) {
            // TODO: log warning
            return save(FootballTeam.builder().championship(championship).name(name).build());
        }
        return footballTeam;
    }
}
