package com.hglobal.demo.db.postgres.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hglobal.demo.db.postgres.entities.EmployeePGEntity;

@Repository
public interface EmployeePGRepository extends JpaRepository<EmployeePGEntity, Long>{

}
