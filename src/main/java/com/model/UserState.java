package com.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserState {
	boolean isAlreadyOnboarded;
	String journeyId;
	JourneyNode stage;

	public UserState(boolean isAlreadyOnboarded, String journeyId,
			JourneyNode stage) {
		super();
		this.isAlreadyOnboarded = isAlreadyOnboarded;
		this.journeyId = journeyId;
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "UserState [isAlreadyOnboarded=" + isAlreadyOnboarded
				+ ", journeyId=" + journeyId + ", stage=" + stage + "]";
	}

}
