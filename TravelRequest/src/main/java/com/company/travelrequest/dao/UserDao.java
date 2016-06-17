package com.company.travelrequest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.travelrequest.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public long countUsers(){
		return entityManager.createQuery("SELECT COUNT(o) FROM User o", Long.class).getSingleResult();
	}
	
	public List<User> findAllUsers(){
		return entityManager.createQuery("SELECT o FROM User o", User.class).getResultList();
	}
	
	public User findUser(Long id){
		 if (id == null) return null;
	     return entityManager.find(User.class, id);
	}
	
	public List<User> findUserEntries(int firstResult, int maxResults){
		return entityManager.createQuery("SELECT o FROM User o", User.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	}
	
	@Transactional
	public void persist(User user){
		this.entityManager.persist(user);
	}
	
	@Transactional
	public void remove(User user){
		 if (this.entityManager.contains(user)) {
	            this.entityManager.remove(user);
	        } else {
	        	User attached = findUser(user.getId());
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
	public User merge(User user){
		User merged = entityManager.merge(user);
		this.entityManager.flush();
		return merged;
	}
	
	public TypedQuery<User> findUserByNameEquals(String name){
		if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
		TypedQuery<User> q = entityManager.createQuery("SELECT o FROM User AS o WHERE o.name = :name", User.class);
		q.setParameter("name", name);
		return q;
	}
}
