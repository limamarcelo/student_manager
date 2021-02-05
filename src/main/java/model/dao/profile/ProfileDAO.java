package model.dao.profile;

import model.entity.profile.Profile;

public interface ProfileDAO {
	
	void insertProfile(Profile profile);
	
	void deleteProfile(Profile profile);
	
	void updateProfile(Profile profile);

}
