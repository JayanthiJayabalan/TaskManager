package com.fsd.taskmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parent_task")
public class ParentTask {

int parent_id;
String parent_task;
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="task_id")
public int getParent_id() {
	return parent_id;
}
public void setParent_id(int parent_id) {
	this.parent_id = parent_id;
}
@Column(name="parent_task")
public String getParent_task() {
	return parent_task;
}
public void setParent_task(String parent_task) {
	this.parent_task = parent_task;
}

}
