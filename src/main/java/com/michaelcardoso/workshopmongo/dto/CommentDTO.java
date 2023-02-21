package com.michaelcardoso.workshopmongo.dto;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private Instant date;
	private String text;
	private AuthorDTO author;
	
	public CommentDTO() {
	}

	public CommentDTO(String id, Instant date, String text, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
}
