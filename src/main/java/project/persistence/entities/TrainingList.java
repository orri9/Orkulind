package project.persistence.entities;

import java.util.ArrayList;
import java.util.List;

// List for Training objects
public class TrainingList {

	// Private variables
    private List<Training> trainingList;

    // Empty Constructor
    public TrainingList() {
    		trainingList = new ArrayList<Training>();
    }

	public List<Training> getTrainingList() {
		return trainingList;
	}

	public void setTrainingList(List<Training> trainingList) {
		this.trainingList = trainingList;
	}
	
	public void add(Training training) {
		trainingList.add(training);
	}
	
	public Training get(int i) {
		return trainingList.get(i);
	}


}
