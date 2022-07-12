package com.jasdhir.ers.model;

public class ERSUser {
private int id;
private String userRole;
private String email;
private String firstName;
private String lastName;
private String userName;
private String password;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUserRole() {
	return userRole;
}
public void setUserRole(String userRole) {
	this.userRole = userRole;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public ERSUser() {
	super();
}
public ERSUser(int id, String userRole, String email, String firstName, String lastName, String userName,
		String password) {
	super();
	this.id = id;
	this.userRole = userRole;
	this.email = email;
	this.firstName = firstName;
	this.lastName = lastName;
	this.userName = userName;
	this.password = password;
}
@Override
public String toString() {
	return "ERSUser [id=" + id + ", userRole=" + userRole + ", email=" + email + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", userName=" + userName + ", password=" + password + "]";
}

}
