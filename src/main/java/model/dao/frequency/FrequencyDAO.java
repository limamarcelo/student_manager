package model.dao.frequency;

import antlr.collections.List;
import model.entity.frequency.Frequency;

public interface FrequencyDAO {
	
	void insertFrequency(Frequency frequency);
	
	void removeFrequency(Frequency frequency);
	
	void updateFrequency(Frequency frequency);
	
	list<Frequency> listFrequency();

}
