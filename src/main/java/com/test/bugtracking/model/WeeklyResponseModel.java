package com.test.bugtracking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.test.bugtracking.model.*;

@Embeddable
public class WeeklyResponseModel {
	
	private Long projectId;
	private List<WeeklySummary> weeklySummaries = new ArrayList<>();

	public WeeklyResponseModel() {
	}

	public WeeklyResponseModel(Long projectId, List<WeeklySummary> weeklySummaries) {
		super();
		this.projectId = projectId;
		this.weeklySummaries = weeklySummaries;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public List<WeeklySummary> getWeeklySummaries() {
		return weeklySummaries;
	}

	public void setWeeklySummaries(List<WeeklySummary> weeklySummaries) {
		this.weeklySummaries = weeklySummaries;
	}

}
