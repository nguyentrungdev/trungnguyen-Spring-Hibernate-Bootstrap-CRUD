package com.aavn.trungnguyen.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aavn.trungnguyen.domain.ApplicantEmail;
import com.aavn.trungnguyen.dao.IApplicantEmailDAO;

@Repository
public class ApplicantEmailDAOImpl implements IApplicantEmailDAO{

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@Override
	@Transactional
	public Integer add(ApplicantEmail applicantEmail) {
		Session session = sessionFactory.getCurrentSession();
		return (Integer)session.save(applicantEmail);
	}

	@Override
	@Transactional
	public boolean update(ApplicantEmail applicantEmail) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(applicantEmail);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(ApplicantEmail applicantEmail) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(applicantEmail);
	}
	
	@Override
	@Transactional
	public void delete(ApplicantEmail applicantEmail) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(applicantEmail);
	}
	
	@Override
	@Transactional
	public void deleteById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete("from ApplicantEmail AM Where AM.Id = " + id);
	}
	
	@Override
	@Transactional
	public ApplicantEmail getById(Integer applicantEmailId) {
		Session session = sessionFactory.getCurrentSession();
		return (ApplicantEmail)session.get(ApplicantEmail.class, applicantEmailId);
	}
	
	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<ApplicantEmail> getAllActive() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM ApplicantEmail";
		Query query = session.createQuery(hql);
		return query.list();
	}
	
	@Override
	@Transactional
	public boolean delete(String[] ids) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "Delete From ApplicantEmail AM Where AM.id = :id";
			Query query = session.createQuery(hql);
			for (int i = 0; i < ids.length; i++) {
				query.setInteger("id", Integer.parseInt(ids[i]));
				query.executeUpdate();
			}
			tx.commit();
		} catch (Exception ex) {
			if (tx != null) tx.rollback();
			throw ex;
		} finally {
			session.close();
		}
		return true;
	}

}
