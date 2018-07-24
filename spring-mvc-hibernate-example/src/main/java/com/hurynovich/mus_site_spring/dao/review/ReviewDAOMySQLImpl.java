package com.hurynovich.mus_site_spring.dao.review;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hurynovich.mus_site_spring.bean.Review;

@Repository("reviewDao")
@DependsOn("sessionFactory")
@Transactional
public class ReviewDAOMySQLImpl implements IReviewDAO {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory factory;

	@Override
	public void addReview(Review review) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(review);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
	        }
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Review getReviewById(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query<Review> query = session.createQuery("FROM Review WHERE id = :i", Review.class);
			query.setParameter("i", id);
			Review review = query.getSingleResult();
			transaction.commit();
			return review;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
	        }
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Review> getAllReviews() {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query<Review> query = session.createQuery("FROM Review", Review.class);
			List<Review> reviews = query.getResultList();
			transaction.commit();
			return reviews;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
	        }
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	@Override
	public void editReview(int id, String title, String text) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Review SET title = :r_title, text = :r_text"
				+ " WHERE id = :r_id");
			query.setParameter("r_title", title);
			query.setParameter("r_text", text);
			query.setParameter("r_id", id);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
	        }
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteReview(int id) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM Review WHERE id = :i");
			query.setParameter("i", id);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
	        }
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
}
