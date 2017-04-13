/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package com.savik.football.repository;

import com.savik.football.model.Match;
import org.springframework.stereotype.Repository;
import repository.JpaEntryRepository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface MatchRepository extends JpaEntryRepository<Match> {
}
