package com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infogain.crewManager.InfogainCrewManagerLeaveManagementService.bo.LeaveDetails;

/**
 * 
 * @author Bhargav.Krishna
 *
 */
@Repository
public interface LeaveManagementRepository extends MongoRepository<LeaveDetails, String> {

}
