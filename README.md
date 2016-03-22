# UserLoginandAdministration
This project an demonstration web application for user administration with Spring MVC and Maven.
@Date 26.02.2016

Features
--------

	Login form for users(admin or user)
	User administration(add,edit,delete), only for admin
	Spring Security authentication and authorization with embedded database
	Obligatory fields checking and syntactical correctness checking with Hibernate Validator
	Exception Handling
	
Libraries
---------

	JDK-1.7
	Maven 3.2
	Spring 4.2.2.RELEASE
	Spring Security 4.0.2.RELEASE
	HSQLDB 2.3.1
	Hibernate Validator 5.2.2.Final
	log4j 1.2.17
	javax.servlet:jstl 1.2

Running the application in Eclipse
-----------------------

	1. Import into Eclipse via existing Maven projects into workspace option.
	2. Run as Maven build ---> Goals: tomcat7:run
	3. Access http://localhost:8080/ 
	4. Initial login data for admin(username:admin password:admin) and user(username:user password:12345)
	


	 

