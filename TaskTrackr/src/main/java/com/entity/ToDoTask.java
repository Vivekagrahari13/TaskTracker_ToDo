package com.entity;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class ToDoTask {
	@Id
	private int id;
	private String title;
	@Column(length = 2000)
	private String content;
	private Date date;

	public ToDoTask() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToDoTask(String title, String content, Date date) {
		super();
		this.id = new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.date = date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
