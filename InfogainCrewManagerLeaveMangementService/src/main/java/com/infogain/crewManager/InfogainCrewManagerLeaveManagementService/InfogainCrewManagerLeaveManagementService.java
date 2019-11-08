package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableEurekaClient
@SpringBootApplication
@EnableMongoRepositories
public class InfogainCrewManagerLeaveManagementService {
	private static final Logger logger = LoggerFactory.getLogger(InfogainCrewManagerLeaveManagementService.class);

	public static void main(String[] args) {

		logger.info("CrewManagerRosterService starting..");

		SpringApplication.run(InfogainCrewManagerLeaveManagementService.class, args);

	}

}
