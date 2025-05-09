package com.museum.entity;

import java.time.LocalDate;

public class Article
{
	private Integer id;
	private String name;
	private Category category;
	private LocalDate createdDate;
	private String createrName;
	
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(Integer id, String name, Category category, LocalDate createdDate, String createrName) {
		
		this.id = id;
		this.name = name;
		this.category = category;
		this.createdDate = createdDate;
		this.createrName = createrName;
	}

	public Integer getId() {
		return id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreaterName() {
		return createrName;
	}

	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", category=" + category + ", createdDate=" + createdDate
				+ ", createrName=" + createrName + "]";
	}
	
	
	
}
