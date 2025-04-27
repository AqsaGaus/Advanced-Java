package com.museum;

import java.time.LocalDate;

import java.util.Scanner;

import com.museum.entity.Category;
import com.museum.service.ArticleService;

public class ArticleMain {

	public static void main(String[] args) 
	{
		ArticleService service = null;
		Scanner sc= new Scanner(System.in);
		try {
			 service = new ArticleService();
			
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		while(true)
		{
			System.out.println("+++++++++ menu +++++++++");
			System.out.println("\n1. Add Article"
					+ "\n2. Display All Article"
					+ "\n3. Display Details of Article"
					+ "\n0. Exit");
			
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
				{
					try {
						System.out.println("Enter Article name , category(PAINTING, SCULPTURE, ARTIFACT) ,"
								+ " created date , creator name : ");
					    String name = sc.next();
					    Category category = Category.valueOf(sc.next());
					    LocalDate date = LocalDate.parse(sc.next());
					    String creatorname = sc.next();
					    
					    service.addArticle(name, category, date, creatorname);
					    
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					break;			
				}
				case 2:
				{
					try {
						service.displayAllArticle();
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				case 3:
				{
					try {
						System.out.println("Enter a Article id :  ");
						service.displayArticleDetails(sc.nextInt());
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				case 0:
				{	
					System.out.println("Thanks\nVisit Again....");
					System.exit(0);
					break;
				}
				
				default :
				{
					System.out.println("Invalid Choice...");
					break;
				}
					
			}
	
		}

	}

}
