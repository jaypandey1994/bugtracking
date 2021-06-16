package com.test.bugtracking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.bugtracking.model.Issue;
import com.test.bugtracking.model.WeeklyResponseModel;
import com.test.bugtracking.repository.IssueChangeLogRepository;
import com.test.bugtracking.repository.IssueRepository;
import com.test.bugtracking.service.BugTrackService;

@RestController
public class BugTrackController {
	
	@Autowired
	private BugTrackService serv;
	@Autowired
	private IssueRepository issueRepository;
	@Autowired
	private IssueChangeLogRepository issueChangeLogRepository;

	@GetMapping("/getWeeklySummary")
	public WeeklyResponseModel getWeeklySummary(@RequestParam(value = "project_id") String project_id,
			@RequestParam(value = "from_week") String fromWeek, @RequestParam(value = "to_week") String toWeek,
			@RequestParam(value = "types") String types, @RequestParam(value = "states") String states) {

		return serv.getWeeklyService(project_id, fromWeek, toWeek, types, states);

	}

	/*
	 * final long calendarWeek = 34; LocalDate desiredDate =
	 * LocalDate.ofYearDay(2020, 50).with(IsoFields.WEEK_OF_WEEK_BASED_YEAR,
	 * calendarWeek) .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY));
	 * return desiredDate;
	 */
}
