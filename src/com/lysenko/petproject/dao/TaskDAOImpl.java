package com.lysenko.petproject.dao;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.lysenko.petproject.model.Task;

public class TaskDAOImpl implements TaskDAO {

	private JdbcTemplate jdbcTemplate;

	public TaskDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Task task) {

		String sql = "INSERT INTO Task (task_title, task_content, task_date, task_time) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, task.getTitle(), task.getContent(), task.getDate(), task.getTime());

	}

	@Override
	public int update(Task task) {
		String sql = "UPDATE Task SET task_title=?, task_content=?, task_date=?, task_time=? WHERE task_id=?";
		return jdbcTemplate.update(sql, task.getTitle(), task.getContent(), task.getDate(), task.getTime(), task.getId());
	}

	@Override
	public Task get(Integer id) {
		String sql = "SELECT * FROM Task WHERE task_id = " + id;

		ResultSetExtractor<Task> extractor = new ResultSetExtractor<Task>() {

			@Override
			public Task extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					String title = rs.getString("task_title");
					String content = rs.getString("task_content");
					Date date = rs.getDate("task_date");
					Time time = rs.getTime("task_time");

					return new Task(id, title, content, date, time);

				}
				return null;
			}

		};

		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM Task WHERE task_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Task> list() {
		String sql = "SELECT * FROM Task";

		RowMapper<Task> rowMapper = new RowMapper<Task>() {

			@Override
			public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("task_id");
				String title = rs.getString("task_title");
				String content = rs.getString("task_content");
				Date date = rs.getDate("task_date");
				Time time = rs.getTime("task_time");

				return new Task(id, title, content, date, time);
			}

		};

		return jdbcTemplate.query(sql, rowMapper);
	}

}
