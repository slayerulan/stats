package com.savik.snooker.repository;

import com.savik.repository.JpaEntryRepository;
import com.savik.snooker.model.SnookerChampionship;
import com.savik.snooker.model.SnookerTeam;
import org.springframework.stereotype.Repository;


@Repository
public interface SnookerTeamRepository extends JpaEntryRepository<SnookerTeam> {

    SnookerTeam findOneByNameAndChampionship_(String name, SnookerChampionship footballChampionship);

    default SnookerTeam findOneByNameAndChampionship(String name, SnookerChampionship championship) {
        SnookerTeam hockeyTeam = findOneByNameAndChampionship_(name, championship);
        if (hockeyTeam == null) {
            // TODO: log warning
            return save(SnookerTeam.builder().championship(championship).name(name).build());
        }
        return hockeyTeam;
    }
}
