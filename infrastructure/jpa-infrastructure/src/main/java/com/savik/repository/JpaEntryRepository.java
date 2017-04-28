package com.savik.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.savik.domain.Identifiable;
import com.savik.filter.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;



@NoRepositoryBean
public interface JpaEntryRepository<T extends Identifiable>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

    default Page<T> findAll(Filter<T> filter, Pageable pageable) {
        return filter == null ? findAll(pageable) : findAll(filter.toSpecification(), pageable);
    }

    default List<T> findAll(Filter<T> filter) {
        return filter == null ? findAll() : findAll(filter.toSpecification());
    }

    @Query("SELECT e FROM #{#entityName} e WHERE e.id = ?1")
    Optional<T> getOneById(Long id);

    default Optional<T> getOne(T entity) {
        return getOneById(entity == null ? null : entity.getId());
    }

    @Query("SELECT e FROM #{#entityName} e")
    Stream<T> streamAll();

    @Query("SELECT e FROM #{#entityName} e")
    Stream<T> streamAll(Pageable pageable);

    @Modifying
    default void deleteAll(List<Long> ids) {
        deleteInBatch(findAll(ids));
    }

    @Modifying
    void deleteByIdIn(List<Long> ids);
}
