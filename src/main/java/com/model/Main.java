package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.exception.JourneyAlreadyExistForGivenId;
import com.exception.JourneyDoesNotExist;
import com.exception.UserAlreadyExistForGivenId;
import com.exception.UserDoesNotExist;

public class Main {

	public static void main(String[] args) {

		JourneyRepository journeyRepo = new JourneyRepository();
		UserRepository userRepo = new UserRepository();

		JourneyServiceImpl journeyService = new JourneyServiceImpl(journeyRepo);
		UserServiceImpl userService = new UserServiceImpl(userRepo,
				journeyRepo);

		// name, criteria, isOnboardingStage, isTerminalStage, nextStages
		JourneyNode jn3 = new JourneyNode("StageC", null, false, true, null);
		JourneyNode jn4 = new JourneyNode("StageD", null, false, true, null);

		List<JourneyNode> jn2List = new ArrayList<>();
		jn2List.add(jn3);
		jn2List.add(jn4);
		JourneyNode jn2 = new JourneyNode("StageB", null, false, false,
				jn2List);

		List<JourneyNode> j11List = new ArrayList<>();
		j11List.add(jn2);
		JourneyNode jn1 = new JourneyNode("StageA", null, true, false, j11List);

		// id, journeyState, journeyType, startNode
		Journey journey = new Journey("journeyId", JourneyState.Created,
				JourneyType.Perpetual, jn1);

		// id, name, userState
		User user = new User("userId", "userName",
				new UserState(false, null, null));

		try {
			journeyService.createJourney(journey);
			System.out.println(journeyService.getJourney("journeyId"));

			journeyService.updateState("journeyId", JourneyState.Active);
			// journeyService.updateState("journeyId1", JourneyState.Active);

			System.out.println(journeyService.getJourney("journeyId"));
			// System.out.println(journeyService.getJourney("journeyId1"));

			userRepo.addUser(user);
			Payload payload = new Payload();
			payload.journeyId = "journeyId";
			payload.criteria = new HashMap<>();
			payload.criteria.put("canOnboard", true);
			payload.criteria.put("StageA->StageB", true);
			payload.criteria.put("StageB->StageD", true);

			System.out.println("Is User Onboarded "
					+ userService.isOnboarded("userId", "journeyId"));

			userService.evaluate("userId", payload);

			System.out.println("Is User Onboarded "
					+ userService.isOnboarded("userId", "journeyId"));
			System.out.println(
					userService.getCurrentStage("userId", "journeyId"));

			userService.evaluate("userId", payload);
			System.out.println(
					userService.getCurrentStage("userId", "journeyId"));

			userService.evaluate("userId", payload);
			System.out.println(
					userService.getCurrentStage("userId", "journeyId"));

			// userService.evaluate("userId1", payload);

			// Payload payload1 = new Payload();
			// payload.journeyId = "journeyId1";
			// userService.evaluate("userId", payload1);
		} catch (JourneyAlreadyExistForGivenId e) {
			System.out.println(e);
		} catch (JourneyDoesNotExist e) {
			System.out.println(e);
		} catch (UserAlreadyExistForGivenId e) {
			System.out.println(e);
		} catch (UserDoesNotExist e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
