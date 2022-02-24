package com.spring.backoffice.repository;

import com.spring.backoffice.model.SignalementComplet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface SignalementCompletRepository extends JpaRepository<SignalementComplet, Long> {

    @Query(value = "SELECT  id,\n" +
            "        idClient,\n" +
            "        idTypeSignalement,\n" +
            "        idRegion,\n" +
            "        idStatut,\n" +
            "        nom,\n" +
            "        prenom,\n" +
            "        email,\n" +
            "        dateHeure,\n" +
            "        designation,\n" +
            "        typeSignalement,\n" +
            "        nomRegion,\n" +
            "        nomStatut\n" +
            "    FROM signalement_complet\n" +
            "\t where idclient = :idclient and id = :id \n" +
            "    GROUP BY id, idClient, idTypeSignalement,\n" +
            "            idRegion, idStatut, nom, prenom, email,\n" +
            "            dateHeure, designation,\n" +
            "            typeSignalement, nomRegion, nomStatut ", nativeQuery = true)
    SignalementComplet findByIdclientAndAndId(@Param("idclient") Long idclient,
                                              @Param("id") Long id);


    @Query(value = "SELECT  id,\n" +
            "        idClient,\n" +
            "        idTypeSignalement,\n" +
            "        idRegion,\n" +
            "        idStatut,\n" +
            "        nom,\n" +
            "        prenom,\n" +
            "        email,\n" +
            "        dateHeure,\n" +
            "        designation,\n" +
            "        typeSignalement,\n" +
            "        nomRegion,\n" +
            "        nomStatut\n" +
            "    FROM signalement_complet\n " +
            "\t where idtypesignalement = :idtypesignalement\n" +
            "   and idstatut = :idstatut\n" +
            "    GROUP BY id, idClient, idTypeSignalement,\n" +
            "            idRegion, idStatut, nom, prenom, email,\n" +
            "            dateHeure, designation,\n" +
            "            typeSignalement, nomRegion, nomStatut ", nativeQuery = true)
    List<SignalementComplet> findByIdTypesignalementAndIdstatut(@Param("idtypesignalement") Long idtypesignalement,
                                                                @Param("idstatut") Long idstatut);


    @Query(value = "SELECT  id,\n" +
            "        idClient,\n" +
            "        idTypeSignalement,\n" +
            "        idRegion,\n" +
            "        idStatut,\n" +
            "        nom,\n" +
            "        prenom,\n" +
            "        email,\n" +
            "        dateHeure,\n" +
            "        designation,\n" +
            "        typeSignalement,\n" +
            "        nomRegion,\n" +
            "        nomStatut\n" +
            "    FROM signalement_complet\n" +
            "    GROUP BY id, idClient, idTypeSignalement,\n" +
            "            idRegion, idStatut, nom, prenom, email,\n" +
            "            dateHeure, designation,\n" +
            "            typeSignalement, nomRegion, nomStatut " +
            "   ORDER BY dateHeure desc", nativeQuery = true)
    List<SignalementComplet> findToutOrderDate();
}
