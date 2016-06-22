package com.company.travelrequest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.loader.custom.Return;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.travelrequest.model.Tour;

@Repository
public class TourDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long countTours(){
		return entityManager.createQuery("SELECT COUNT(o) FROM Tour o", Long.class).getSingleResult();
	}
	
	public List<Tour> findAllTours(){
		return entityManager.createQuery("SELECT o FROM Tour o", Tour.class).getResultList();
	}
	
	public List<Tour> findAllTours(Long userId){
		return entityManager.createQuery("SELECT o FROM Tour o WHERE o.user_id = (:userId)", Tour.class).setParameter("userId", userId).getResultList();
	}
	
	public Tour findTour(Long id){
		if(id == null) return null;
		return entityManager.find(Tour.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Tour> findSubmittedTours(String sts){
		if(sts == null) return null;
		return entityManager.createQuery("SELECT o FROM Tour o WHERE o.status LIKE :sts")
				.setParameter("sts", sts)
				.getResultList();
	}
	
	@Transactional
	public void persist(Tour tour){
		this.entityManager.persist(tour);
	}
	
	@Transactional
	public void remove(Tour tour){
		if(this.entityManager.contains(tour)){
			this.entityManager.remove(tour);
		}else{
			Tour attached = findTour(tour.getId());
			this.entityManager.remove(attached);
		}
	}
	
	@Transactional
    public void flush() {
        this.entityManager.flush();
    }

	@Transactional
    public void clear() {
        this.entityManager.clear();
    }
	
	@Transactional
	public Tour merge(Tour tour){
		Tour merged = entityManager.merge(tour);
		this.entityManager.flush();
		return merged;
	}
}
