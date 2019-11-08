package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("LeaveDetails")
public class LeaveDetails {

	@Id
	private String id;

	private String crewId;

	private String UserName;

	private String EmployeeName;

	private String fromDate;

	private String to_date;

	private String LeaveType;

	private String reason;

	private int duration;

	public void setCrewId(String crewId) {
		this.crewId = crewId;
	}

	public String getCrewId() {
		return crewId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getLeaveType() {
		return LeaveType;
	}

	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}

	public String getReason() {
		return reason;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getTo_date() {
		return to_date;
	}

	public void setTo_date(String to_date) {
		this.to_date = to_date;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
