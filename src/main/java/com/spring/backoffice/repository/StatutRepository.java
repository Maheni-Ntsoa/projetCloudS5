package com.spring.backoffice.repository;

import com.spring.backoffice.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StatutRepository extends JpaRepository<Statut, Long> {

    @Modifying
    @Query(value = "insert into Statut values (DEFAULT, :nomstatut)", nativeQuery = true)
    void insertStatut(@Param("nomstatut") String nomstatut);

    @Modifying
    @Query(value = "update Statut set nomstatut = :nomstatut where id = :id", nativeQuery = true)
    void updateStatut(@Param("nomstatut") String nomstatut, @Param("id") Long id);

    @Modifying
    @Query(value = "delete  from statut where id = :id", nativeQuery = true)
    void deleteStatut(@Param("id") Long id);
}
