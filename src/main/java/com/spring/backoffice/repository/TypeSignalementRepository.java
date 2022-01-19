package com.spring.backoffice.repository;

import com.spring.backoffice.model.TypeSignalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TypeSignalementRepository extends JpaRepository<TypeSignalement, Long> {

    @Modifying
    @Query(value = "insert into TypeSignalement values (DEFAULT, :typeSignalement)", nativeQuery = true)
    void insertTypeSignalement(@Param("typeSignalement") String typeSignalement);

    @Modifying
    @Query(value = "update TypeSignalement set typeSignalement = :typeSignalement where id = :id", nativeQuery = true)
    void updateTypeSignalement(@Param("typeSignalement") String typeSignalement, @Param("id") Long id);

    @Modifying
    @Query(value = "delete from TypeSignalement where id = :id", nativeQuery = true)
    void deleteTypeSignalement(@Param("id") Long id);

}

