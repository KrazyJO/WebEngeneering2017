package com.micromata.webengineering.demo.post;

import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.micromata.webengineering.demo.user.User;
import javax.persistence.PrePersist;

@Entity
public class Post {

	public static final int TITLE_LENGTH = 1024;
	
	/**
     * Constructor for Post's CrudRepository (findAll).
     *
     * @param author
     * @param title
     * @param createdAt
     */
    public Post(Long id, User author, String title, Date createdAt) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.createdAt = createdAt;
//        comments = new LinkedList<>();
    }
	
    public Post()
    {
    	
    }
    
	private static final int titleLength = 1024;
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Long id;
	
	private Date createdAt; //Exercise: time of creation
	
	@Column(length = titleLength)
	private String title;
	
	@ManyToOne
	private User author;
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(Date d) {
		this.createdAt = d;
	}

	@JsonProperty
	public Long getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getAuthor() {
		return author;
	}
	
	public void setAuthor(User author) {
		this.author = author;
	}
	
	@PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
