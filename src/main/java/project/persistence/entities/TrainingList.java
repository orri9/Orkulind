package project.persistence.entities;

import java.util.ArrayList;
import java.util.List;

public class TrainingList {

    private List<Training> trainingList;

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
