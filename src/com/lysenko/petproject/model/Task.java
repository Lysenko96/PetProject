package com.lysenko.petproject.model;

import java.sql.Date;
import java.sql.Time;

public class Task {

	private Integer task_id;
	private String task_title;
	private String task_content;
	private Date task_date;
	private Time task_time;

	public Task() {
	}

	public Task(int id, String title, String content, Date date, Time time) {
		this(title, content, date, time);
		this.task_id = id;
	}

	public Task(String title, String content, Date date, Time time) {
		this.task_title = title;
		this.task_content = content;
		this.task_date = date;
		this.task_time = time;
	}

	public Integer getId() {
		return task_id;
	}

	public void setId(Integer id) {
		this.task_id = id;
	}

	public String getTitle() {
		return task_title;
	}

	public void setTitle(String title) {
		this.task_title = title;
	}

	public String getContent() {
		return task_content;
	}

	public void setContent(String content) {
		this.task_content = content;
	}

	public Date getDate() {
		return task_date;
	}

	public void setDate(Date date) {
		this.task_date = date;
	}

	public Time getTime() {
		return task_time;
	}

	public void setTime(Time time) {
		this.task_time = time;
	}

	@Override
	public String toString() {
		return "Task [task_id=" + task_id + ", task_title=" + task_title + ", task_content=" + task_content
				+ ", task_date=" + task_date + ", task_time=" + task_time + "]";
	}

}
