package com.test.bugtracking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.test.bugtracking.model.Issue;
import com.test.bugtracking.model.IssueChangeLog;
import com.test.bugtracking.model.IssueState;
import com.test.bugtracking.model.IssueType;
import com.test.bugtracking.repository.IssueChangeLogRepository;
import com.test.bugtracking.repository.IssueRepository;

@SpringBootApplication
public class BugtrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugtrackingApplication.class, args);
	}
	
	/*
	 * @Bean CommandLineRunner commandLineRunner(IssueRepository
	 * issueRepository,IssueChangeLogRepository issueChangeLogRepository){ return
	 * args->{ Issue issue1=new Issue(1L,1L,IssueType.bug,IssueState.open);
	 * 
	 * IssueChangeLog icl1=new IssueChangeLog(1L, LocalDate.now(), issue1,
	 * IssueState.open, IssueState.in_progress); IssueChangeLog icl2=new
	 * IssueChangeLog(1L, LocalDate.now(), issue1, IssueState.open,
	 * IssueState.deploy);
	 * 
	 * 
	 * 
	 * issue1.addIssueChangeLog(icl1); issue1.addIssueChangeLog(icl2);
	 * issueRepository.save(issue1);
	 * 
	 * //issueChangeLogRepository.saveAll(iclList); }; }
	 */
}
