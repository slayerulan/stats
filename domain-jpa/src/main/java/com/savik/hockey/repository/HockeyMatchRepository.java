package com.savik.hockey.repository;

import com.savik.hockey.model.HockeyMatch;
import com.savik.hockey.model.HockeyMatch_;
import com.savik.repository.JpaEntryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HockeyMatchRepository extends JpaEntryRepository<HockeyMatch> {
    HockeyMatch findByMyscoreCode(String code);

    @Override
    default List<HockeyMatch> findAll() {
        Sort defaultSort = new Sort(Sort.Direction.DESC, HockeyMatch_.date.getName());
        return findAll(defaultSort);
    };

    @Override
    default List<HockeyMatch> findAll(Specification<HockeyMatch> specification, Integer size) {
        Sort defaultSort = new Sort(Sort.Direction.DESC, HockeyMatch_.date.getName());
        if (size == null) {
            return findAll(specification, defaultSort);
        }
        final PageRequest page =
                new PageRequest(0, size, defaultSort);
        return findAll(specification, page).getContent();
    }
}
