package com.test.bugtracking.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.test.bugtracking.model.*;

@Embeddable
public class StateSummary {

	private IssueState state;
	private Integer count;
	private List<Issue> issues = new ArrayList<>();

	public StateSummary() {
	}

	public StateSummary(IssueState state, Integer count, List<Issue> issues) {
		super();
		this.state = state;
		this.count = count;
		this.issues = issues;
	}

	public IssueState getState() {
		return state;
	}

	public void setState(IssueState state) {
		this.state = state;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Issue> getIssues() {
		return issues;
	}

	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}

}
