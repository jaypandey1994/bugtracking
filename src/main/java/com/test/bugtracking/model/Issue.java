package com.test.bugtracking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Table(name = "issue", uniqueConstraints = { @UniqueConstraint(name = "issue_id_unique", columnNames = "issueId") })
@Entity(name = "Issue")
public class Issue implements Serializable {

	private static final long serialVersionUID = 8628213209991197392L;

	@JsonIgnore
	private Long projectId;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issueId")
	private Long issueId;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private IssueType type;

	@JsonIgnore
	@Column(name = "currentState", columnDefinition = "TEXT")
	@Enumerated(EnumType.STRING)
	private IssueState currentState;

	@JsonIgnore
	@OneToMany(mappedBy = "issueId" ,cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@Column(name = "changeLogs")
	private List<IssueChangeLog> changeLogs = new ArrayList<>();

	public Issue() {
		super();
	}

	public Issue(Long projectId, Long issueId, IssueType type, IssueState currentState) {
		super();
		this.projectId = projectId;
		this.issueId = issueId;
		this.type = type;
		this.currentState = currentState;
	}
	public Issue(Long projectId, Long issueId, IssueType type, IssueState currentState,
			List<IssueChangeLog> changeLogs) {
		super();
		this.projectId = projectId;
		this.issueId = issueId;
		this.type = type;
		this.currentState = currentState;
		this.changeLogs = changeLogs;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getIssueId() {
		return issueId;
	}

	public void setIssueId(Long issueId) {
		this.issueId = issueId;
	}

	public IssueType getType() {
		return type;
	}

	public void setType(IssueType type) {
		this.type = type;
	}

	public IssueState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(IssueState currentState) {
		this.currentState = currentState;
	}

	public List<IssueChangeLog> getChangeLogs() {
		return changeLogs;
	}

	public void setChangeLogs(List<IssueChangeLog> changeLogs) {
		this.changeLogs = changeLogs;
	}
	
	public void addIssueChangeLog(IssueChangeLog issueChangeLog) {
		if(!this.changeLogs.contains(issueChangeLog)) {
			this.changeLogs.add(issueChangeLog);
			issueChangeLog.setIssueId(this);
		}
	}

	@Override
	public String toString() {
		return "Issue [projectId=" + projectId + ", issueId=" + issueId + ", type=" + type + ", currentState="
				+ currentState + "]";
	}
	
	
	
	

}
