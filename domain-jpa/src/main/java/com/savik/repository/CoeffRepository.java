package com.savik.repository;

import com.savik.CoeffEntry;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CoeffRepository extends JpaEntryRepository<CoeffEntry> {
    List<CoeffEntry> findByMyscoreCode(String code);

    @Modifying
    void deleteAllByMyscoreCode(String code);
}
