package com.rest.doa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.entity.TourPackage;

public interface TourRepository extends JpaRepository<TourPackage, Integer> 
{
	TourPackage findBypackageName(String packageName);
}
