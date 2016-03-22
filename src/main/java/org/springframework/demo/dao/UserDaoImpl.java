package org.springframework.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.demo.model.User;

/**
 * This class implements data access actions. the initialization and configuration of database are setup in /WEB-INF/appServlet-context.xml. 
 * @author 
 * 
 */
@Repository
public class UserDaoImpl implements UserDao{
		
	
	
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * retrieves list of all users from database.
	 */
	//@Override
	public List<User> getAllUser(){
		
		List<User> result = jdbcTemplate.query("SELECT * from users", new UserMapper());
		return result;
	}
	
	/**
	 * retrieves records of an user with requested id from database.
	 */
	@Override
	public User getUser(int id){
		User result = jdbcTemplate.queryForObject("SELECT * FROM users WHERE user_id = ?", new Object[]{id} ,new UserMapper());
		return result;
	}
	
	/**
	 * adds records of an user into database.
	 */
	@Override
	public void addUser(User user){
		jdbcTemplate.update("INSERT INTO users (firstname, lastname, email, username, password, enabled) VALUES (?, ?, ?, ?, ?, true)", 
				user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getPassword());
		jdbcTemplate.update("insert into user_roles (username, role) values (?, ?)", user.getUsername(), "ROLE_USER");
	}
	
	/**
	 * updates records of an user with requested id in the database.
	 */
	@Override
	public void updateUser(int id, User user){
		jdbcTemplate.update("UPDATE users SET firstname = ?, lastname = ?, email = ?, username = ?, password = ? WHERE user_id = ?"
				, user.getFirstname(), user.getLastname(), user.getEmail(), user.getUsername(), user.getPassword(), id);
		jdbcTemplate.update("UPDATE user_roles SET username = ? WHERE user_role_id = ?", user.getUsername(), id);
	}
	
	/**
	 * deletes records of an user with requested id from the database.
	 */
	@Override
	public void deleteUser(int id){
		jdbcTemplate.update("DELETE from users WHERE user_id = ?", id);
		jdbcTemplate.update("DELETE from user_roles WHERE user_role_id = ?", id);
	}
	
	private static final class UserMapper implements RowMapper<User> {
		
	    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        User user = new User();
	        user.setId(rs.getInt("user_id"));
	        user.setFirstname(rs.getString("firstname"));
	        user.setLastname(rs.getString("lastname"));
	        user.setEmail(rs.getString("email"));
	        user.setUsername(rs.getString("username"));
	        user.setPassword(rs.getString("password"));	 
	        return user;
	    }
	}
	
	public void setDataSource(DataSource dataSource) {  
		this.dataSource = dataSource;  
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);  
	}  
		  
	public DataSource getDataSource() {  
		return dataSource;  
	}  
	
}
