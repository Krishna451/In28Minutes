package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo.LeaveDetails;
import com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.respository.LeaveManagementRepository;

/**
 * 
 * @author Bhargav.Krishna
 *
 */
@Service
public class LeaveManageService {
	
	@Autowired
	private LeaveManagementRepository leaveManagementRepository;
	
	@SuppressWarnings("unchecked")
	public LeaveDetails applyLeave(LeaveDetails leaveDetails) {
		
		/*
		 * int duration=leaveDetails.getTo_date().getDate()-leaveDetails.getFromDate().
		 * getDate();
		 * 
		 * leaveDetails.setDuration(duration + 1);
		 */
		
		leaveDetails.setDuration(1 + 1);
		
		return (LeaveDetails) leaveManagementRepository.save(leaveDetails);	
	}

}
