package com.rest.service;

import java.util.Collection;

import com.rest.entity.TourPackage;

public interface ITourService 
{
		//Create tour package
		boolean createTourPackage(TourPackage newTeam);
		
		//Read tour packages
		Collection<TourPackage> allTAllTourPackage();
		
		//Read single tour package (By tour name)
		TourPackage getTourByName(String packageName);
		
		//Upgrade tour plan
		TourPackage updateTourPackage(Integer packageId, TourPackage tour);
		
		//Delete stock
		void deleteTourPackage(Integer packageId);
}