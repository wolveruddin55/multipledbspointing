package com.hglobal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hglobal.demo.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/get-non-sync-employees")
	public List<String> nonSyncEmployees() {
		return employeeServiceImpl.filteredEmails();
	}
}
