package com.funfit.usjr.thesis.backend.service;

import java.util.List;

public interface NotificationService {
	public void broadcast(List<String> items) throws Exception;
}
