package com.fsd.taskmanager.service;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.fsd.taskmanager.entity.Task;

@Service
public class TaskService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addTask(Task task){
		
		Integer l = (Integer)jdbcTemplate.queryForObject("select  coalesce(max(parent_id)+1,1) from parent_task", Integer.class);
		
		String query = "insert into parent_task(parent_id,parent_task) values("+l+",'"+task.getParentTask()+"')";
		jdbcTemplate.execute(query);  
		
	    String sQuery = "INSERT INTO task(parent_id,task,start_date,end_date,priority,status) "
	    		+ " VALUES("+l+",'"+task.getTask()+"','"+task.getStartDate()+"','"+task.getEndDate()+"','"+task.getPriority()+"','"+task.getStatus()+"')";
	    jdbcTemplate.execute(sQuery);  
	  }

	public void editTask(Task task) {
		 String updateTaskSQL = "update task set task =?, priority=?, start_date=?, end_date=? where task_id =? ";
		 int[] types = {Types.VARCHAR,Types.INTEGER,Types.DATE,Types.DATE,Types.INTEGER};
		 Object[] params = {task.getTask(),task.getPriority(),task.getStartDate(),task.getEndDate(),task.getTaskId()};
		 jdbcTemplate.update(updateTaskSQL,params,types);
				 
		 String updateParentQry = "update parent_task set parent_task =? where parent_id =? ";
		 Object[] parentObj = {task.getParentTask(),task.getParentTask()};
		 int[] parentObjType = {Types.VARCHAR,Types.INTEGER};
		 jdbcTemplate.update(updateParentQry,parentObj,parentObjType);
	}

	public List<Task> getAllTasks() {
		//String sql = "select t.task_id,t.task,t.priority,t.start_date,t.end_date, t.status,pt.parent_task,pt.parent_id as parentTaskId from task t left join parent_task pt on t.parent_id=pt.parent_id";
		String sql = "select t.task_id,pt.parent_task,pt.parent_id as parentTaskId from task t left join parent_task pt on t.parent_id=pt.parent_id";
		List<Task> taskList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Task.class));
		return taskList;
	}
	
	public List<Task> deleteTask(int task_id) {
		 String updateTaskSQL = "update task set status='inactive' where task_id =? ";
		 Object[] params = {task_id};
		 int[] type = {Types.INTEGER};
		 jdbcTemplate.update(updateTaskSQL,params,type);
		 return getAllTasks();
	}

	
}
