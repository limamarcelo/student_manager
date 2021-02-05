package model.dao.frequency;

<<<<<<< HEAD
import java.util.List;
=======
import antlr.collections.List;
>>>>>>> 2edcb37834c4a0eeab036d3ab15078607bb2ba10
import model.entity.frequency.Frequency;

public interface FrequencyDAO {
	
	void insertFrequency(Frequency frequency);
	
	void removeFrequency(Frequency frequency);
	
	void updateFrequency(Frequency frequency);
	
	list<Frequency> listFrequency();

}
