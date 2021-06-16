package com.test.bugtracking.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Table(name = "issue_change_log", uniqueConstraints = { @UniqueConstraint(name = "changelog_id_unique", columnNames = "id") })
@Entity(name = "IssueChangeLog")
public class IssueChangeLog implements Serializable {

	private static final long serialVersionUID = 1818501686982688402L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id" )
	private Long id;
	
	@Column(name = "changedOn")
	private LocalDate changedOn;
	
	@ManyToOne
	@JoinColumn(name="issueId",referencedColumnName = "issueId", foreignKey = @ForeignKey(name="issue_change_log_fk"))
	private Issue issueId;
	
	@Column(name = "from_state")
	@Enumerated(EnumType.STRING)
	private IssueState from_state;
	
	@Column(name = "to_state")
	@Enumerated(EnumType.STRING)
	private IssueState to_state;

	public IssueChangeLog() {
		super();
	}

	public IssueChangeLog(Long id, LocalDate changedOn, Issue issueId, IssueState from_state, IssueState to_state) {
		super();
		this.id = id;
		this.changedOn = changedOn;
		this.issueId = issueId;
		this.from_state = from_state;
		this.to_state = to_state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getChangedOn() {
		return changedOn;
	}

	public void setChangedOn(LocalDate changedOn) {
		this.changedOn = changedOn;
	}

	public Issue getIssueId() {
		return issueId;
	}

	public void setIssueId(Issue issue) {
		this.issueId = issue;
	}

	public IssueState getFrom_state() {
		return from_state;
	}

	public void setFrom_state(IssueState from_state) {
		this.from_state = from_state;
	}

	public IssueState getTo_state() {
		return to_state;
	}

	public void setTo_state(IssueState to_state) {
		this.to_state = to_state;
	}

	@Override
	public String toString() {
		return "IssueChangeLog [id=" + id + ", changedOn=" + changedOn + ", issueId=" + issueId + ", from_state="
				+ from_state + ", to_state=" + to_state + "]";
	}
	
	
	
	

}
