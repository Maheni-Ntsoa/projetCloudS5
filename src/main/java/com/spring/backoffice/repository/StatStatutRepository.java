package com.spring.backoffice.repository;

import com.spring.backoffice.model.StatStatut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StatStatutRepository extends JpaRepository<StatStatut, String>  {
}
