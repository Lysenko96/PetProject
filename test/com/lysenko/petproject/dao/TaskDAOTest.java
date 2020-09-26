package com.lysenko.petproject.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lysenko.petproject.model.Task;

class TaskDAOTest {

	private DriverManagerDataSource dataSource;
	private TaskDAO dao;

	@BeforeEach
	void setUp() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbtasks?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");

		dao = new TaskDAOImpl(dataSource);
	}

	@Test
	void testSave() {
		long now = System.currentTimeMillis();
		Time sqlTime = new Time(now);
		Task task = new Task("task for work", "create summary", new Date(1601047141541l), sqlTime);
		int result = dao.save(task);
		assertTrue(result > 0);

	}

	@Test
	void testUpdate() {
		long now = System.currentTimeMillis();
		Time sqlTime = new Time(now);
		Task task = new Task(2, "task for work", "create resume", new Date(1601047141541l), sqlTime);
		int result = dao.update(task);
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Task task = dao.get(id);
		if (task != null) {
			System.out.println(task);
		}
		assertNotNull(task);
	}

	@Test
	void testDelete() {
		Integer id = 17;
		int result = dao.delete(id);
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Task> listTasks = dao.list();

		for (Task task : listTasks) {
			System.out.println(task);
		}

		assertTrue(!listTasks.isEmpty());
	}

}
