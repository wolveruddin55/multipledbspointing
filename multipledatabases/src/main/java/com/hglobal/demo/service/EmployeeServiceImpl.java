package com.hglobal.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hglobal.demo.db.mysql.repo.EmployeeMYSQLRepository;
import com.hglobal.demo.db.postgres.repo.EmployeePGRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeMYSQLRepository employeeMYSQLRepository;

	@Autowired
	EmployeePGRepository employeePGRepository;

	@Override
	public List<String> filteredEmails() {
		List<String> returnString = new ArrayList<>();
		try {
			List<String> emailIdsMySQL = employeeMYSQLRepository.findAll().stream().map(v -> v.getEmailId())
					.collect(Collectors.toList());
			List<String> emailIdsPostGresSQL = employeePGRepository.findAll().stream().map(v -> v.getEmail())
					.collect(Collectors.toList());
			if (emailIdsMySQL.size() != emailIdsPostGresSQL.size()) {
				returnString.addAll(emailIdsMySQL.stream().filter(v -> !emailIdsPostGresSQL.contains(v)).collect(Collectors.toList()));
			}
		} catch (Exception e) {
			throw e;
		}
		System.out.println(returnString.get(0));
		return returnString;
	}

}
