package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyFutureMatch;
import com.savik.hockey.model.HockeyFutureMatch_;
import com.savik.repository.JpaEntryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface HockeyFutureMatchRepository extends JpaEntryRepository<HockeyFutureMatch> {
    HockeyFutureMatch findByMyscoreCode(String code);

    @Override
    default List<HockeyFutureMatch> findAll() {
        Sort defaultSort = new Sort(Sort.Direction.ASC, HockeyFutureMatch_.date.getName());
        return findAll(defaultSort);
    }

    @Modifying
    @Transactional
    void deleteByDateBefore(LocalDateTime expiryDate);

}
