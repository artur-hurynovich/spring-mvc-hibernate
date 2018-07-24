package com.hurynovich.mus_site_spring.service.review;

import java.util.Date;
import java.util.List;

import com.hurynovich.mus_site_spring.bean.Review;

public interface IReviewService {
	
	void addReview(String title, String text, Date date, String authorName);
	
	Review getReviewById(int id);
	
	List<Review> getAllReviews();
	
	void editReview(int id, String title, String text);
	
	void deleteReview(int id);
}
