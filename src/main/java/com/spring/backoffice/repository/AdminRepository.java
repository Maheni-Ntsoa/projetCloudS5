package com.spring.backoffice.repository;

import com.spring.backoffice.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findByEmailAndMdp(String email, String mdp);
}
