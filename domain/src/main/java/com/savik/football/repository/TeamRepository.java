package com.savik.football.repository;

import com.savik.football.model.Championship;
import com.savik.football.model.Team;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface TeamRepository extends JpaEntryRepository<Team> {

    Team findOneByNameAndChampionship_(String name, Championship championship);

    default Team findOneByNameAndChampionship(String name, Championship championship) {
        Team team = findOneByNameAndChampionship_(name, championship);
        if (team == null) {
            // TODO: log warning
            return save(Team.builder().championship(championship).name(name).build());
        }
        return team;
    }
}
