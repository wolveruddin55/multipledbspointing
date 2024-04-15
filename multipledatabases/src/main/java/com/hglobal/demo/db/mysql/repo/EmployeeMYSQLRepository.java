package com.hglobal.demo.db.mysql.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hglobal.demo.db.mysql.entities.EmployeeMySQLEntity;

public interface EmployeeMYSQLRepository extends JpaRepository<EmployeeMySQLEntity, Integer>{

}
