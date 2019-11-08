package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo.LeaveDetails;
import com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.services.LeaveManageService;

@RestController
@CrossOrigin("*")
public class LeaveManagementController {

	@Autowired
	private LeaveManageService leaveManageService;

	// @Autowired
	// private UserInfoService userInfoService;

	@PostMapping("/apply-leave")
	@ResponseBody
	public ResponseEntity<LeaveDetails> createEmployeeLeave(@RequestBody LeaveDetails leaveDetails) {
		System.out.println("crewId::" + leaveDetails.getCrewId());
		return new ResponseEntity(leaveManageService.applyLeave(leaveDetails), HttpStatus.OK);

	}
}
