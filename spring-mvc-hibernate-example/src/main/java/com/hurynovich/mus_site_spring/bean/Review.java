package com.hurynovich.mus_site_spring.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review implements Serializable {
	private static final long serialVersionUID = 993491152105160292L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int id;
	@Column(name = "review_title")
	private String title;
	@Column(name = "review_text")
	private String text;
	@Column(name = "review_date")
	private Date date;
	@Column(name = "author_name")
	private String authorName;

	public Review() {
		
	}
	
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getTitlePreview() {
		if (title.length() >= 30) {
			return title.substring(0, 30) + "...";
		} else {
			return title;
		}
	}
	
	public String getTextPreview() {
		if (text.length() >= 100) {
			return text.substring(0, 100) + "...";
		} else {
			return text;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (this == obj) return true;
		if (getClass() != obj.getClass()) return false;
		Review temp = (Review) obj;
		
		boolean titleEquals = false;
		if (title != null) {
			titleEquals = title.equals(temp.title);
		} else {
			titleEquals = (temp.title == null);
		}
		
		boolean textEquals = false;
		if (text != null) {
			textEquals = text.equals(temp.text);
		} else {
			textEquals = (temp.text == null);
		}
		
		boolean dateEquals = false;
		if (date != null) {
			dateEquals = date.equals(temp.date);
		} else {
			dateEquals = (temp.date == null);
		}
		
		boolean authorNameEquals = false;
		if (authorName != null) {
			authorNameEquals = authorName.equals(temp.authorName);
		} else {
			authorNameEquals = (temp.authorName == null);
		}
		
		return (titleEquals && textEquals && dateEquals && authorNameEquals);
	}
	
	@Override
	public int hashCode() {
		int res = 13;
		final int PRIME = 25;
		
		res = res * PRIME + id;
		
		if (title != null) {
			res = res * PRIME + title.hashCode();
		}
		
		if (text != null) {
			res = res * PRIME + text.hashCode();
		}
		
		if (date != null) {
			res = res * PRIME + date.hashCode();
		}
		
		if (authorName != null ) {
			res = res * PRIME + authorName.hashCode();
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		return "ID: " + getId() + "\n" +
			"Title: " + getTitlePreview() + "\n" +
			"Text: " + getTextPreview() + "\n" +
			"Date: " + getDate() + "\n" +
			"Author: " + getAuthorName();
	}
}
