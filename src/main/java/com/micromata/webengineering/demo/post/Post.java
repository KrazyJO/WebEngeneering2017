package com.micromata.webengineering.demo.post;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.micromata.webengineering.demo.comment.Comment;
import com.micromata.webengineering.demo.user.User;
import javax.persistence.PrePersist;

@Entity
public class Post {

	public static final int TITLE_LENGTH = 1024;
	
	private static final int titleLength = 1024;
	
	@Id
	@JsonIgnore
	@GeneratedValue
	private Long id;
	
	private Date createdAt; //Exercise: time of creation
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;
	
	@Column(length = titleLength)
	private String title;
	
	@ManyToOne
	private User author;
	
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
        comments = new LinkedList<>();
    }
	
    public Post()
    {
    	comments = new LinkedList<>();
    }
    
	
	
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
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
