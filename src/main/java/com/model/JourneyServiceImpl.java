package com.model;

import com.exception.JourneyAlreadyExistForGivenId;
import com.exception.JourneyDoesNotExist;

public class JourneyServiceImpl implements JourneyService {

	JourneyRepository journeyRepo;

	JourneyServiceImpl(JourneyRepository jr) {
		journeyRepo = jr;
	}

	@Override
	public Journey createJourney(Journey journey)
			throws JourneyAlreadyExistForGivenId {

		journeyRepo.addJourney(journey);

		return journey;
	}

	@Override
	public void updateState(String journeyId, JourneyState journeyState)
			throws JourneyDoesNotExist {
		// TODO Auto-generated method stub
		Journey j = journeyRepo.getJourney(journeyId);
		j.journeyState = journeyState;
	}

	@Override
	public Journey getJourney(String journeyId) throws JourneyDoesNotExist {
		return journeyRepo.getJourney(journeyId);
	}
}
