package com.webapp.springboot.thymeleafdemo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="blog_posts")
public class BlogPost {

	// define fields

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="title")
	private String title;

	@Column(name="content")
	private String content;

	@Column(name="created_at")
	private Date created_at;
	@Column(name="updated_at")
	private Date updated_at;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH }, fetch=FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();


	// define constructors

	public BlogPost() {

	}

	public BlogPost(int id, String title, String content, Date created_at, Date updated_at, User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.user = user;
	}
// define getter/setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// define tostring
	@Override
	public String toString() {
		return "BlogPost{" +
				"id=" + id +
				", title='" + title + '\'' +
				", content='" + content + '\'' +
				", created_at=" + created_at +
				", updated_at=" + updated_at +
				", user=" + user +
				'}';
	}
}











