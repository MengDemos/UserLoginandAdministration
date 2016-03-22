package org.springframework.demo.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

/**
 * User Model
 * @author 
 *
 */
public class User {
    private int id;
    
    @NotNull(message="Please enter firstname")
    private String firstname;
    
    @NotNull(message="Please enter lastname")
    private String lastname;
    
    @NotNull(message="Please enter email address")
    @Email(message="Please enter a correct email address")
    private String email;
    
    @NotNull(message="Please enter username")
    private String username;
    
    @NotNull(message="Please enter password")
    private String password;
    

    public User() {
		super();
	}
    
    public User(int id, String firstname, String lastname, String email, String username, String password, String role) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return String.format(
                "User [id=%s, firstname=%s, lastname=%s, email=%s, username=%s, password=%s]", id,
                firstname, lastname, email, username, password);
    }
}
