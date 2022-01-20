package com.spring.backoffice.repository;

import com.spring.backoffice.model.Admin;
import com.spring.backoffice.model.Signalement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SignalementRepository extends JpaRepository<Signalement, Long> {

    @Modifying
    @Query("update Signalement s set s.idregion = :idregion where s.id = :idsignalement")
    void affecterRegion(@Param("idsignalement") Long idsignalement, @Param("idregion") Long idregion);

    @Query(value = "select * from Signalement where idregion = 0", nativeQuery = true)
    List<Signalement> findByIdRegionNull();

}
