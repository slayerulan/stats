package com.savik.football.repository;

import com.savik.football.model.FootballReferee;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballRefereeRepository extends JpaEntryRepository<FootballReferee> {

    FootballReferee findOneByName_(String name);

    default FootballReferee findOneByName(String name) {
        FootballReferee footballTeam = findOneByName_(name);
        if (footballTeam == null) {
            return save(new FootballReferee(name));
        }
        return footballTeam;
    }
}
