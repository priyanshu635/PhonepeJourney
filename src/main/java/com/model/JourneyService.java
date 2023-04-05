package com.model;

import com.exception.JourneyAlreadyExistForGivenId;
import com.exception.JourneyDoesNotExist;

public interface JourneyService {

	Journey createJourney(Journey journey) throws JourneyAlreadyExistForGivenId;

	void updateState(String journeyId, JourneyState journeyState)
			throws JourneyDoesNotExist;

	Journey getJourney(String journeyId) throws JourneyDoesNotExist;

}
