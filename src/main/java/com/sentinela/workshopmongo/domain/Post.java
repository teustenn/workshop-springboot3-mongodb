package com.sentinela.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Post implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private User author;
	private Date date;
	private String title;
	private String body;
	
	public Post() {
	}

	public Post(String id, User author, Date date, String title, String body) {
		this.id = id;
		this.author = author;
		this.date = date;
		this.title = title;
		this.body = body;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
}
