package com.hurynovich.mus_site_spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hurynovich.mus_site_spring.bean.Review;
import com.hurynovich.mus_site_spring.service.review.IReviewService;

@Controller
@DependsOn("reviewService")
public class PageController {
	@Autowired
	@Qualifier("reviewService")
	private IReviewService reviewService;
	
	private final String readReviewPage = "/WEB-INF/jsp/reviews/reviews_read.jsp";
	private final String reviewPage = "/WEB-INF/jsp/reviews/reviews.jsp";
	private final String newReviewPage = "/WEB-INF/jsp/reviews/reviews_new.jsp";
	private final String editReviewPage = "/WEB-INF/jsp/reviews/reviews_edit.jsp";
	
	@RequestMapping("/newReview")
	public String executeNewReviewPage(HttpServletRequest request) {
		return newReviewPage;
	}
	
	@RequestMapping("/readReview")
	public String executeReadReviewPage(HttpServletRequest request, Model model) {
		String reviewIdParam = request.getParameter("reviewId");
		int reviewId = Integer.valueOf(reviewIdParam);
		Review review = reviewService.getReviewById(reviewId);
		model.addAttribute("review", review);
		return readReviewPage;
	}
	
	@RequestMapping("/allReviews")
	public String executeReviewsPage(HttpServletRequest request, Model model) {
		List<Review> reviews = reviewService.getAllReviews();
		model.addAttribute("reviews", reviews);
		return reviewPage;
	}
	
	@RequestMapping("/editReview")
	public String executeEditReviewPage(HttpServletRequest request, Model model) {
		String reviewIdParam = request.getParameter("reviewId");
		int reviewId = Integer.valueOf(reviewIdParam);
		Review review = reviewService.getReviewById(reviewId);
		model.addAttribute("review", review);
		return editReviewPage;
	}
}
