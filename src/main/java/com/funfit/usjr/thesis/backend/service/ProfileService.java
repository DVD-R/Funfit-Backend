package com.funfit.usjr.thesis.backend.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.models.ProfileRequestJson;
import com.funfit.usjr.thesis.backend.models.ResponseJson;


public interface ProfileService {
	List<ResponseJson> generateResponse(ProfileRequestJson profileRequestJson);
}
