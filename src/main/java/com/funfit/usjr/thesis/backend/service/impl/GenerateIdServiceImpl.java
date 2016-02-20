package com.funfit.usjr.thesis.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.service.GenerateIdService;

@Service("generateIdService")
@Transactional
public class GenerateIdServiceImpl implements GenerateIdService{

	public GenerateIdServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int generateId() {
		// TODO Auto-generated method stub
		return (int) Math.floor(System.currentTimeMillis() / 1000L);
	}

}
