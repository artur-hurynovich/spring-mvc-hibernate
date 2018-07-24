package com.hurynovich.mus_site_spring.service.review;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.hurynovich.mus_site_spring.bean.Review;
import com.hurynovich.mus_site_spring.dao.review.IReviewDAO;

@Service("reviewService")
@DependsOn("reviewDao")
public class ReviewServiceImpl implements IReviewService {
	@Autowired
	@Qualifier("reviewDao")
	private IReviewDAO reviewDao;

	@Override
	public void addReview(String title, String text, Date date, String authorName) {
		Review review = new Review();
		review.setTitle(title);
		review.setText(text);
		review.setDate(date);
		review.setAuthorName(authorName);
		reviewDao.addReview(review);
	}

	@Override
	public Review getReviewById(int id) {
		return reviewDao.getReviewById(id);
	}

	@Override
	public List<Review> getAllReviews() {
		return reviewDao.getAllReviews();
	}
	
	@Override
	public void editReview(int id, String title, String text) {
		reviewDao.editReview(id, title, text);
	}

	@Override
	public void deleteReview(int id) {
		reviewDao.deleteReview(id);
	}
}
