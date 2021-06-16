package com.test.bugtracking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.test.bugtracking.model.*;

@Embeddable
public class WeeklySummary {

	private String week;
	private List<StateSummary> stateSummaries = new ArrayList<>();

	public WeeklySummary() {
	}

	public WeeklySummary(String week, List<StateSummary> stateSummaries) {
		super();
		this.week = week;
		this.stateSummaries = stateSummaries;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public List<StateSummary> getStateSummaries() {
		return stateSummaries;
	}

	public void setStateSummaries(List<StateSummary> stateSummaries) {
		this.stateSummaries = stateSummaries;
	}

}
