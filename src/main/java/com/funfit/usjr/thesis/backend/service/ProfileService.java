package com.funfit.usjr.thesis.backend.service;

import java.util.List;

import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.Rdi;


public interface ProfileService {
	List<Rdi> generateResponse(ProfileRequestJson profileRequestJson, int faction_id);
}
