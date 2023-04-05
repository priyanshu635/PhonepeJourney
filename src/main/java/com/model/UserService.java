package com.model;

import com.exception.JourneyDoesNotExist;
import com.exception.UserDoesNotExist;

public interface UserService {

	void evaluate(String userId, Payload payload)
			throws UserDoesNotExist, JourneyDoesNotExist;

	JourneyNode getCurrentStage(String userId, String journeyId)
			throws UserDoesNotExist, JourneyDoesNotExist;

	boolean isOnboarded(String userId, String journeyId)
			throws UserDoesNotExist, JourneyDoesNotExist;

}
