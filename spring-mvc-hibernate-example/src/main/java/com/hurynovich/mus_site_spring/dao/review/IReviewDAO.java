package com.hurynovich.mus_site_spring.dao.review;

import java.util.List;

import com.hurynovich.mus_site_spring.bean.Review;

public interface IReviewDAO {
	
	void addReview(Review review);
	
	Review getReviewById(int id);
	
	List<Review> getAllReviews();
	
	void editReview(int id, String title, String text);
	
	void deleteReview(int id);
}
