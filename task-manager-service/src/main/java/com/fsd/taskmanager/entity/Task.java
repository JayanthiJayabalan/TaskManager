package com.fsd.taskmanager.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	 
	public Task() {
		super();
	}
	
	int taskId;
	String task;
	int priority;
	Date startDate;
	Date endDate;
	String status;
	int parentTaskId;
	@Column(name="parent_task")
	String parentTask;
	 
	 
	public Task(int taskId,  String task, int priority, Date startDate, Date endDate,
			int parentTaskId,String status,String parentTask) {
		super();
		this.taskId = taskId;
		this.task = task;
		this.priority = priority;
		this.startDate = startDate;
		this.endDate = endDate;
		this.parentTaskId = parentTaskId;
		this.status=status;
		this.parentTask = parentTask;	
	}
	@Column(name="parent_id")
	public int getParentTaskId() {
		return parentTaskId;
	}
	public void setParentTaskId(int parentTaskId) {
		this.parentTaskId = parentTaskId;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="task_id")
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	@Column(name="task")
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	@Column(name="priority")
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	@Column(name="startDate") 
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Column(name="endDate")
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Column(name="status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParentTask() {
		return parentTask;
	}
	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}
	 
	 

}
