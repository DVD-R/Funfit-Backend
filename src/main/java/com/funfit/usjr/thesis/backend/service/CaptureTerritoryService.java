package com.funfit.usjr.thesis.backend.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CaptureTerritoryService {
	public boolean territoryValidation();
}
