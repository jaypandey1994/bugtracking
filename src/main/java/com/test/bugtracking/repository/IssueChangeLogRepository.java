package com.test.bugtracking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.bugtracking.model.IssueChangeLog;

@Repository
public interface IssueChangeLogRepository extends JpaRepository<IssueChangeLog, Long>{

}
