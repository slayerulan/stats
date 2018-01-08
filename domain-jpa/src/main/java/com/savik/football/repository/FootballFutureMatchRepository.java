package com.savik.football.repository;

import com.savik.football.model.FootballFutureMatch;
import com.savik.hockey.model.HockeyFutureMatch_;
import com.savik.repository.JpaEntryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Savushkin Yauheni
 * @since 13.4.17
 */

@Repository
public interface FootballFutureMatchRepository extends JpaEntryRepository<FootballFutureMatch> {

    FootballFutureMatch findByMyscoreCode(String code);

    @Override
    default List<FootballFutureMatch> findAll() {
        Sort defaultSort = new Sort(Sort.Direction.ASC, HockeyFutureMatch_.date.getName());
        return findAll(defaultSort);
    }

    @Modifying
    @Transactional
    void deleteByDateBefore(LocalDateTime expiryDate);
}
