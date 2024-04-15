package com.hglobal.demo.db.mysql;


public interface MYSQLMarkerInterface {

	/*
	 * @AutoWire The Environment object, this is helpful to pull properties from
	 * application.yml define dataSource bean and set the properties like
	 * url,username,password etc.. by getting them from environment
	 * 
	 * define a LocalContainerEntityManagerFactoryBean
	 *  set the dataSource bean defined above  and set other hibernate 
	 *  properties like dialects and logging and which package to scan for entities you need to specify
	 *  
	 *  define a PlatformTransactionManager to manage transactions(create, close) etc..
	 */
}
