package com.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibernatUtils;

//import poly.edu.Utils.JpaUtil;

public class UserDAO {
	private Session hSession;

	public UserDAO() {
		hSession = HibernatUtils.getSession();
	}

	public User store(User entity) {

		this.hSession.beginTransaction();
		Integer id = (Integer) this.hSession.save(entity);
		this.hSession.getTransaction().commit();
		entity.setId(id);

		return entity;
	}

	public List<User> paginate(int perPage, int offset) {
		String hql = "FROM User";
		Query query = this.hSession.createQuery(hql);

		query.setFirstResult(offset);
		query.setMaxResults(offset + perPage);
		List<User> result = query.getResultList();
		return result;
	}

	public void deleteUser() {
		this.hSession.beginTransaction();
		String hql = "delete from User where id = :IdDelete";
		Query query = this.hSession.createQuery(hql);
		query.setParameter("IdDelete", 17);
		int result = query.executeUpdate();
		this.hSession.getTransaction().commit();
		System.out.println("Delete user: " + result);

	}

	public User findById(int id) {

		User entity = this.hSession.get(User.class, id);

		return entity;
	}

	public void updateUser(User entity) {

		try {
			this.hSession.clear();
			this.hSession.beginTransaction();
			this.hSession.update(entity);
			this.hSession.getTransaction().commit();

		} catch (Exception e) {

			System.out.println("RollBack....");
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
		}
	}

	public List<Integer> countUserForFilter() {
		String hql = "select count(id) FROM User";
		Query query = this.hSession.createQuery(hql);
		List<Integer> list1 = query.getResultList();
//		System.out.println("Count users: " + list1.get(0));
		return list1;
	}

	public void delete(User entity) {
		this.hSession.clear();

		try {

			this.hSession.beginTransaction();
			this.hSession.delete(entity);
			this.hSession.getTransaction().commit();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			this.hSession.getTransaction().rollback();
			throw e;
		}
	}
}
