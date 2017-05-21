package main.java.com.micromata.webengineering.demo.post;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Post {

	private Date createdAt; //Exercise: time of creation
	private String title;
	@Id
	@GeneratedValue
	private UUID guid;
	
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

	public UUID getGuid() {
		return guid;
	}
	
	public void setGuid(UUID guid) {
		this.guid = guid;
	}
	
	@PrePersist
    public void prePersist() {
        createdAt = new Date();
    }
}
