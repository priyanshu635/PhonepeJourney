package com.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JourneyNode {

	String name;
	String criteria;

	boolean isOnboardingStage;
	boolean isTerminalStage;

	List<JourneyNode> nextStages;

	public JourneyNode(String name, String criteria, boolean isOnboardingStage,
			boolean isTerminalStage, List<JourneyNode> nextStages) {
		super();
		this.name = name;
		this.criteria = criteria;
		this.isOnboardingStage = isOnboardingStage;
		this.isTerminalStage = isTerminalStage;
		this.nextStages = nextStages;
	}

	@Override
	public String toString() {
		return "JourneyNode [name=" + name + ", criteria=" + criteria
				+ ", isOnboardingStage=" + isOnboardingStage
				+ ", isTerminalStage=" + isTerminalStage + ", nextStages="
				+ nextStages + "]";
	}

}
