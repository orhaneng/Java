package org.orhan.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.orhan.messenger.database.DatabaseClass;
import org.orhan.messenger.model.Message;
import org.orhan.messenger.model.Profile;

public class ProfileService {
	private static Map<String, Profile> profiles = DatabaseClass.getProfiles();

	static {
		profiles.put("omerorhan", new Profile(1L,"omerorhan","omer","orhan"));
	}
	public ProfileService() {
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
