package com.test.bugtracking.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.bugtracking.model.Issue;
import com.test.bugtracking.model.IssueChangeLog;
import com.test.bugtracking.model.IssueState;
import com.test.bugtracking.model.IssueType;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long>{
	
	public List<Issue> findIssueByProjectId(Long projectId);
	
	@Query("Select i FROM Issue i join IssueChangeLog icl on i.issueId= icl.issueId where i.projectId= ?1 and i.type = ?2 and i.currentState = ?3 and icl.changedOn > ?4 and icl.changedOn < ?5")
	public List<Issue> getWeeklyIssue(Long projectId, IssueType type, IssueState state, LocalDate startdate, LocalDate endDate); 
	
	
	//public List<Issue> findIssueByProjectIdEqualsAndTypeEqualsAndCurrentStateEqualsAndChangeLogsAfterAndChangeLogsBefore(Long projectId, IssueType type, IssueState state, LocalDate startdate, LocalDate endDate);
	
		
	
}
