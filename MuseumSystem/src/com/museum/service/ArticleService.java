package com.museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import com.museum.dao.ArticleDao;
import com.museum.entity.Article;
import com.museum.entity.Category;
import com.museum.exception.ResourceAlreadyExistException;
import com.museum.exception.ResourceNotFoundException;

public class ArticleService 
{
	private ArticleDao articleDao;
	
	public ArticleService() throws SQLException 
	{
		articleDao = new ArticleDao();
	}

	public void addArticle(String name , Category category, LocalDate createdDate, 
			String createrName) throws SQLException
	{
		Optional<Article> existingArticle = articleDao.findAll().stream()
		.filter(art -> art.getName().equalsIgnoreCase(name))
		.findFirst();
		
		if(existingArticle.isEmpty())
		{
			Article newArticle =  new Article(0, name, category, createdDate, createrName);
			boolean status = articleDao.save(newArticle);
			
			if(status)
				System.out.println("Article added successfully.");
			else
				System.out.println("Article failed to add.");
		}
		else
		{
			throw new ResourceAlreadyExistException("Article already exist with the same"
					+ " name : "+name);
		}
	}
	
	
	public void displayAllArticle() throws SQLException
	{
		articleDao.findAll().stream().forEach(art ->System.out.println(art));;
	}
	
	public void displayArticleDetails(Integer id) throws SQLException
	{
		Article foundArticle =  articleDao.findById(id);
		if(foundArticle != null)
		{
			System.out.println(foundArticle);
		}
		else
		{
			throw new ResourceNotFoundException("Resource not found of id : "+id);
		}
	}
}
