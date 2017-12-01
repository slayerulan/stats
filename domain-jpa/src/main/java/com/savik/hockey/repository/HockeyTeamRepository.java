package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyChampionship;
import com.savik.hockey.model.HockeyTeam;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HockeyTeamRepository extends JpaEntryRepository<HockeyTeam> {

    HockeyTeam findOneByNameAndChampionship_(String name, HockeyChampionship footballChampionship);

    default HockeyTeam findOneByNameAndChampionship(String name, HockeyChampionship championship) {
        HockeyTeam hockeyTeam = findOneByNameAndChampionship_(name, championship);
        if (hockeyTeam == null) {
            // TODO: log warning
            return save(HockeyTeam.builder().championship(championship).name(name).build());
        }
        return hockeyTeam;
    }
}
