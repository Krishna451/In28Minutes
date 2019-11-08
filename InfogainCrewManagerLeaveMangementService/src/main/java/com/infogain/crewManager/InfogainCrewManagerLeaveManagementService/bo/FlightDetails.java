package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo;

public class FlightDetails {

	private String flightDetailsId;
	private String pairingName;
	private String flightNo;
	private String departureTime;
	private String arrivalTime;
	private String sectorsForFlights;
	private String airCraftType;
	private String airCraftRegistration;
	private String date;

	public String getFlightDetailsId() {
		return flightDetailsId;
	}

	public void setFlightDetailsId(String flightDetailsId) {
		this.flightDetailsId = flightDetailsId;
	}

	public String getPairingName() {
		return pairingName;
	}

	public void setPairingName(String pairingName) {
		this.pairingName = pairingName;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getSectorsForFlights() {
		return sectorsForFlights;
	}

	public void setSectorsForFlights(String sectorsForFlights) {
		this.sectorsForFlights = sectorsForFlights;
	}

	public String getAirCraftType() {
		return airCraftType;
	}

	public void setAirCraftType(String airCraftType) {
		this.airCraftType = airCraftType;
	}

	public String getAirCraftRegistration() {
		return airCraftRegistration;
	}

	public void setAirCraftRegistration(String airCraftRegistration) {
		this.airCraftRegistration = airCraftRegistration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FlightDetails [flightDetailsId=" + flightDetailsId + ", pairingName=" + pairingName + ", flightNo="
				+ flightNo + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", sectorsForFlights=" + sectorsForFlights + ", airCraftType=" + airCraftType
				+ ", airCraftRegistration=" + airCraftRegistration + ", date=" + date + "]";
	}

}
