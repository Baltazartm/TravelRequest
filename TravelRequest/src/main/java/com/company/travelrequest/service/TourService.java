package com.company.travelrequest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.travelrequest.dao.TourDao;
import com.company.travelrequest.dao.UserDao;
import com.company.travelrequest.model.Tour;
import com.company.travelrequest.model.User;

@Service
public class TourService {

	@Autowired
	private TourDao tourDao;
	
	@Autowired
	private UserDao userDao;
	
	
	public long countAllTours(){
		return tourDao.countTours();
	}
	
	public Tour findTour(Long id){
		return tourDao.findTour(id);
	}
	
	// Query to find all travel record
	public List<Tour> findAllTours(){
		return tourDao.findAllTours();
	}
	
//	Overiding method above to find travel record for specific user
	public List<Tour> findAllTours(Object sess){
		Long user = Long.parseLong((String) sess);
		return tourDao.findAllTours(user);
	}
	
	public List<Tour> findSubmittedTours(){
		String sts = "2";
		return tourDao.findSubmittedTours(sts);
	}
	
	public void saveTour(Tour tour){
//		User employee = userDao.findUser(tour.getUserId().)
		tourDao.persist(tour);
	}
	
	public Tour editTour(Tour tour){
		return tourDao.merge(tour);
	}
}
