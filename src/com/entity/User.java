package com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="users")
public class User implements Serializable {
	


@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", age=" + age
				+ ", number=" + number + ", gender=" + gender + ", role=" + role + "]";
	}

public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
	
public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column(name="id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	@Column(name="name")
	 private String name;
	
	@Column(name="email")
	 private String email;
	
	@Column(name="password")
	 private String password;
	
	@Column(name="age")
	 private Integer age;
	
	
	@Column(name="number")
	 private String number;
	
	@Column(name="gender")
	 private Integer gender;
	
	@Column(name="role")
	 private Integer role;
	
	
	@OneToMany(
			mappedBy = "user",
			fetch = FetchType.LAZY
			)
	
	private List<Post> posts;
	public List<Post> getPosts(){
		return posts;
	}
	
	
	
	

}
