package com.infogain.crewManager.InfogainCrewManagerServerGateway.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.infogain.crewManager.InfogainCrewManagerServerGateway.auth.JwtToken;

@Repository
public interface JwtTokenRepository extends MongoRepository<JwtToken,String> {
}