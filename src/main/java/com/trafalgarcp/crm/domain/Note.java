package com.trafalgarcp.crm.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 0, max = 500)
	@NotNull(message = "note must not be empty")
	private String content;
	private Date createdDate;
	private Integer reviewHistory; // how many time the note was updated
	private Date lastUpdatedDate; // Date the note was updated
	private String author; // user who created the note
	private String tiedTo; // note added in reference to a company or a professional/project/ transaction
	private String title;

	public Note() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getReviewHistory() {
		return reviewHistory;
	}

	public void setReviewHistory(Integer reviewHistory) {
		this.reviewHistory = reviewHistory;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTiedTo() {
		return tiedTo;
	}

	public void setTiedTo(String tiedTo) {
		this.tiedTo = tiedTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
