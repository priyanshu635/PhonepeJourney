package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Journey {
	String id;

	JourneyState journeyState;
	JourneyType journeyType;

	JourneyNode startNode;

	public Journey(String id, JourneyState journeyState,
			JourneyType journeyType, JourneyNode startNode) {
		super();
		this.id = id;
		this.journeyState = journeyState;
		this.journeyType = journeyType;
		this.startNode = startNode;
	}

	@Override
	public String toString() {
		return "Journey [id=" + id + ", journeyState=" + journeyState
				+ ", journeyType=" + journeyType + ", startNode=" + startNode
				+ "]";
	}

}
