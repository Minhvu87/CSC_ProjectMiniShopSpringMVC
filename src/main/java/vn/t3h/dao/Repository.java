package vn.t3h.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public abstract class Repository {
	final protected JdbcTemplate jdbc;

	public Repository() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/minishop");
		dataSource.setUsername("root");
		dataSource.setPassword("Minh@vu87");
		jdbc = new JdbcTemplate(dataSource);
	}
}
