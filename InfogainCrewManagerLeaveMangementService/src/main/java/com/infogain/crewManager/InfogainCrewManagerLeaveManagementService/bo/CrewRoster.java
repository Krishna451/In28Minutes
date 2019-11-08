package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CrewRoster")
public class CrewRoster {

	@Id
	private String id;
	private String crewId;
	private Set<FlightDetails> flightDetails;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCrewId() {
		return crewId;
	}

	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}

	public Set<FlightDetails> getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(Set<FlightDetails> flightDetails) {
		this.flightDetails = flightDetails;
	}

	@Override
	public String toString() {
		return "CrewRoster [id=" + id + ", crewId=" + crewId + ", flightDetails=" + flightDetails + "]";
	}

}
