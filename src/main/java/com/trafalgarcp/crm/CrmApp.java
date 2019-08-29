package com.trafalgarcp.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@SpringBootApplication
//@EnableJpaRepositories(basePackages = {"com.trafalgarcp.crm.domain"})
//@EntityScan(basePackages = {"com.trafalgarcp.crm.domain"})
@ComponentScan({"com.trafalgarcp.crm.constraints","com.trafalgarcp.crm.controllers","com.trafalgarcp.crm.services","com.trafalgarcp.crm.dto","com.trafalgarcp.crm.repository"})
public class CrmApp {

		public static void main(String[] args) {
			SpringApplication.run(CrmApp.class, args);
			
			
		}
}


