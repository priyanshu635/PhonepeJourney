package com.model;

import java.util.HashMap;
import java.util.Map;

import com.exception.JourneyAlreadyExistForGivenId;
import com.exception.JourneyDoesNotExist;

public class JourneyRepository {

	public static Map<String, Journey> journies = new HashMap<>();

	public Journey addJourney(Journey journey)
			throws JourneyAlreadyExistForGivenId {

		if (this.journies.containsKey(journey.id))
			throw new JourneyAlreadyExistForGivenId();

		this.journies.put(journey.id, journey);

		return journey;
	}

	public Journey getJourney(String id) throws JourneyDoesNotExist {
		if (!journies.containsKey(id))
			throw new JourneyDoesNotExist();

		return journies.get(id);
	}

}
