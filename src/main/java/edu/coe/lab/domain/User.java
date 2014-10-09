package edu.coe.lab.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="user", uniqueConstraints=@UniqueConstraint(columnNames={"USER_NAME", "PASS_WORD"}))
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="USER_ID", unique=true, nullable=false)
	private Integer userId;
	
	@Column(name="USER_NAME", unique=true, nullable=false, length=30)
	private String username;
	
	@Column(name="PASS_WORD", nullable=false, length=30)
	private String password;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private UserDetail userDetail;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	private Set<Blog> blogs = new HashSet<Blog>();
	
	public Set<Blog> getBlogs() {
		return blogs;
	}
	
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	
	public UserDetail getUserDetail() {
		return userDetail;
	}
	
	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	
}
