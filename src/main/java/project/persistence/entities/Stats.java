package project.persistence.entities;

import java.util.Date;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;


public class Stats {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
    private Exercise exercise;
    List<Training> trainings;
    
    Double totalReps;
    Double averageReps;

    public Stats() {
    }

    public Stats(Date startDate, Date endDate, Exercise exercise, List<Training> trainings) {
    		this.startDate = startDate;
    		this.endDate = endDate;
    		this.exercise = exercise;
    		this.trainings = trainings;
    }
    
    public void calculate() {
    		calculateTotalReps();
    		calculateAverageReps();
	}
    
    public void calculateAverageReps() {
		averageReps = totalReps/trainings.size();
	}  
	
	public void calculateTotalReps() {
		Double sumReps = 0.0;
		for(Training t : trainings) {
			sumReps += t.getReps();
		}
		totalReps = sumReps;
	}   
    
    
    
    // Getters & Setters

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public List<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Double getTotalReps() {
		return totalReps;
	}

	public void setTotalReps(Double totalReps) {
		this.totalReps = totalReps;
	}

	public Double getAverageReps() {
		return averageReps;
	}

	public void setAverageReps(Double averageReps) {
		this.averageReps = averageReps;
	}
    
    

}
