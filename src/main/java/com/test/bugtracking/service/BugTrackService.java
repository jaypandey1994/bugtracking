package com.test.bugtracking.service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.test.bugtracking.model.Issue;
import com.test.bugtracking.model.IssueChangeLog;
import com.test.bugtracking.model.IssueState;
import com.test.bugtracking.model.IssueType;
import com.test.bugtracking.model.StateSummary;
import com.test.bugtracking.model.WeeklyResponseModel;
import com.test.bugtracking.model.WeeklySummary;
import com.test.bugtracking.repository.IssueChangeLogRepository;
import com.test.bugtracking.repository.IssueRepository;

@Service
@Transactional
public class BugTrackService {
	
	@Autowired
	private IssueRepository issueRepo;
	
	@Autowired
	private IssueChangeLogRepository issueChangeLogRepo;
	
	List<WeeklyResponseModel> weeklyResponseModels=new ArrayList<>();
	List<WeeklySummary> weeklySummaries=new ArrayList<>() ;
	List<StateSummary> stateSummaries=new ArrayList<>();
	List<Issue> issues=new ArrayList<>();
	
	

	public WeeklyResponseModel getWeeklyService(String project_id, String fromWeek, String toWeek, String types,
			String states) {

		LocalDate startDate = getDateOfWeek(fromWeek);
		LocalDate endDate = getDateOfWeek(toWeek);
		IssueType issueType=IssueType.valueOf(types);
		IssueState issueState=IssueState.valueOf(states);
		Long projectId= Long.parseLong(project_id);
		
		
		
		WeeklyResponseModel weeklyResponseModel=new WeeklyResponseModel();
		WeeklySummary weeklySummary =new WeeklySummary();
		StateSummary stateSummary=new StateSummary();
		Issue issu=new Issue();
		
		 //List<Issue> issueList=issueRepo.findIssueByProjectId(projectId);
		 List<Issue> issueList=issueRepo.getWeeklyIssue(projectId, issueType, issueState, startDate, endDate);
		System.out.println(issueList);
		
		for (Issue issue : issueList) {
			issu.setIssueId(issue.getIssueId());
			issu.setType(issue.getType());
			issues.add(issu);
			
			stateSummary.setState(issue.getCurrentState());
			stateSummary.setCount(issueList.size());
			stateSummary.setIssues(issueList);
			stateSummaries.add(stateSummary);
			
			List<IssueChangeLog> iclList=issue.getChangeLogs();
			for(IssueChangeLog icl : iclList) {
				weeklySummary.setWeek(icl.getChangedOn().toString());
			}
			weeklySummary.setStateSummaries(stateSummaries);
			weeklySummaries.add(weeklySummary);
			
			
			weeklyResponseModel.setProjectId(issue.getProjectId());
			weeklyResponseModel.setWeeklySummaries(weeklySummaries);
			
		}
		return weeklyResponseModel;
	}

	private LocalDate getDateOfWeek(String yearWeek) {
		String year = yearWeek.substring(0, 4);
		String week = yearWeek.substring(5, 7);

		final long calendarWeek = Long.parseLong(week);
		final int calenderyear = Integer.parseInt(year);
		LocalDate desiredDate = LocalDate.ofYearDay(calenderyear, 50)
				.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek)
				.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
		return desiredDate;

	}

}
