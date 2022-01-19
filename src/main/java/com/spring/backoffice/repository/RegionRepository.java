package com.spring.backoffice.repository;


import com.spring.backoffice.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegionRepository extends JpaRepository<Region, Long> {
    @Modifying
    @Query(value = "insert into Region values (DEFAULT, :nomregion)", nativeQuery = true)
    void insertRegion(@Param("nomregion") String nomregion);

    @Modifying
    @Query(value = "update Region set nomregion = :nomregion where id = :id", nativeQuery = true)
    void updateRegion(@Param("nomregion") String nomregion, @Param("id") Long id);

    @Modifying
    @Query(value = "delete  from Region where id = :id", nativeQuery = true)
    void deleteRegion(@Param("id") Long id);
}
