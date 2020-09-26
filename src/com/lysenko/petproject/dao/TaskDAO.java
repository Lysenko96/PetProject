package com.lysenko.petproject.dao;

import java.util.List;

import com.lysenko.petproject.model.Task;

public interface TaskDAO {

	public int save(Task task);

	public int update(Task task);

	public Task get(Integer id);

	public int delete(Integer id);

	public List<Task> list();

}
