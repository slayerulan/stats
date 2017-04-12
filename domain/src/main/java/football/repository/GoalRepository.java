/*
 * Copyright (c) 2017, AT-Consulting. All Rights Reserved.
 * Use is subject to license terms.
 */

package football.repository;

import football.model.Goal;
import org.springframework.stereotype.Repository;
import repository.JpaEntryRepository;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface GoalRepository extends JpaEntryRepository<Goal> {
}
