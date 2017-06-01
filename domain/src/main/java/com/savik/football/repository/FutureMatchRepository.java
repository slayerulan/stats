package com.savik.football.repository;

import com.savik.football.model.FutureMatch;
import com.savik.repository.JpaEntryRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FutureMatchRepository extends JpaEntryRepository<FutureMatch> {

}
