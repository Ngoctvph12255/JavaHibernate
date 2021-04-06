package com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post implements Serializable{
	
		
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Column(name="title")
		private String title;
		
		@Column(name="content")
		private String content;
		
		@Column(name="image")
		private String image;
		
//		SELECT * FROM posts
//		INNER JOIN user ON posts.user_id = user.id
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="user_id")
		private User user;
		
		
//		@Column(name="user_id")
//		private String user_id;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public User getUser() {
			return user;
		}
		public void setUser(User user) {
			this.user = user;
		}
		
		
		public Post() {
			// TODO Auto-generated constructor stub
		}
		
}
