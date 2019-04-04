package project.persistence.entities;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class Stats {
	
	// Private variables
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
    
	private int userId;
	
	private Exercise exercise;
    private List<Training> trainings;

    private Double totalReps;
    private Double averageReps;
    private List<List<Map<Object,Object>>> dataPoints = new ArrayList<List<Map<Object,Object>>>();

    
    // Empty constructor
    public Stats() {
    }

    // Constructor
    public Stats(Date startDate, Date endDate, Exercise exercise, List<Training> trainings) {
    		this.startDate = startDate;
    		this.endDate = endDate;
    		this.exercise = exercise;
    		this.trainings = trainings;
    }
    
    public Stats(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
    }
    
    public Stats(Exercise exercise2, Date startDate2, Date endDate2) {
		this.exercise = exercise2;
		this.startDate = startDate2;
		this.endDate = endDate2;
	}

	// Calculates all
    public void calculate() {
    		calculateTotalReps();
    		calculateAverageReps();
    		calculateDataPoints();
	}
    
    // Average reps
    public void calculateAverageReps() {
		averageReps = totalReps/trainings.size();
	}  
	
    // Total reps
	public void calculateTotalReps() {
		Double sumReps = 0.0;
		for(Training t : trainings) {
			sumReps += t.getReps();
		}
		totalReps = sumReps;
	}   
    
	// Data points for the progress chart in statistics
	// Each point consists of date and rep count
	public void calculateDataPoints() {
		Map<Object,Object> map = null;
		List<Map<Object,Object>> points = new ArrayList<Map<Object,Object>>();
		for(Training t : trainings) {
			map = new HashMap<Object,Object>(); map.put("x", t.getDate().getTime()); 
			map.put("y", t.getReps());
			points.add(map);
		}
		
		dataPoints.add(points);
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
	@JsonIgnore
	public void setAverageReps(Double averageReps) {
		this.averageReps = averageReps;
	}
	@JsonIgnore
	public List<List<Map<Object, Object>>> getDataPoints() {
		return dataPoints;
	}

	public void setDataPoints(List<List<Map<Object, Object>>> dataPoints) {
		this.dataPoints = dataPoints;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
    
    

}

 class Points {
	private int x;
	private int y;
	
	public Points(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setY(int y) { this.y = y; }
	public int getY() {return this.y;}
	public void setX(int x) { this.x = x; }
	public int getX() {return this.x;}	
}
