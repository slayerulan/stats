package com.savik.repository;

import com.savik.CoeffEntry;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoeffRepository extends JpaEntryRepository<CoeffEntry> {
    List<CoeffEntry> findByMyscoreCode(String code);
}
