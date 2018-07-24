package com.hurynovich.mus_site_spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurynovich.mus_site_spring.service.review.IReviewService;

@Controller
public class ReviewController {
	@Autowired
	@Qualifier("reviewService")
	private IReviewService reviewService;
	
	private final String reviewPage = "redirect:/allReviews";
	
	@RequestMapping("/new")
	public String executeNewReview(HttpServletRequest request) {
		String reviewTitle = request.getParameter("title");
		String reviewText = request.getParameter("text");
		Date reviewDate = new Date();
		String reviewAuthorName = request.getParameter("authorName");
		reviewService.addReview(reviewTitle, reviewText, reviewDate, reviewAuthorName);
		return reviewPage;
	}
	
	@RequestMapping("/edit")
	public String executeEditReview(HttpServletRequest request) {
		String reviewIdParam = request.getParameter("reviewId");
		int reviewId = Integer.valueOf(reviewIdParam);
		String reviewTitle = request.getParameter("title");
		String reviewText = request.getParameter("text");
		reviewService.editReview(reviewId, reviewTitle, reviewText);
		return reviewPage;
	}
	
	@RequestMapping("/delete")
	public String executeDeleteReview(HttpServletRequest request) {
		String reviewIdParam = request.getParameter("reviewId");
		int reviewId = Integer.valueOf(reviewIdParam);
		reviewService.deleteReview(reviewId);
		return reviewPage;
	}
}
