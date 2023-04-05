package com.model;

import com.exception.JourneyDoesNotExist;
import com.exception.UserAlreadyExistForGivenId;
import com.exception.UserDoesNotExist;

public class UserServiceImpl implements UserService {

	UserRepository userRepo;
	JourneyRepository journeyRepo;

	UserServiceImpl(UserRepository ur, JourneyRepository jr) {
		userRepo = ur;
		journeyRepo = jr;
	}

	public User addUser(User user) throws UserAlreadyExistForGivenId {
		return userRepo.addUser(user);
	}

	@Override
	public void evaluate(String userId, Payload payload)
			throws UserDoesNotExist, JourneyDoesNotExist {
		User u = userRepo.getUser(userId);
		Journey j = journeyRepo.getJourney(payload.journeyId);

		if (!u.userState.isAlreadyOnboarded
				&& payload.criteria.containsKey("canOnboard")) {
			UserState us = new UserState(true, j.id, j.startNode);
			u.userState = us;
			return;
		}

		if (u.userState.isAlreadyOnboarded) {
			JourneyNode jNode = u.userState.stage;

			for (JourneyNode jn : jNode.nextStages) {
				if (payload.criteria.containsKey(jNode.name + "->" + jn.name)) {
					u.userState.stage = jn;
					return;
				}
			}
		}
	}

	@Override
	public JourneyNode getCurrentStage(String userId, String journeyId)
			throws UserDoesNotExist, JourneyDoesNotExist {
		User u = userRepo.getUser(userId);
		Journey j = journeyRepo.getJourney(journeyId);

		if (u.userState.isAlreadyOnboarded) {
			return u.userState.stage;
		}

		return null;
	}

	@Override
	public boolean isOnboarded(String userId, String journeyId)
			throws UserDoesNotExist, JourneyDoesNotExist {

		User u = userRepo.getUser(userId);
		Journey j = journeyRepo.getJourney(journeyId);
		if (u.userState.isAlreadyOnboarded
				&& u.userState.journeyId.equals(journeyId)) {
			return true;
		}

		return false;
	}

}
