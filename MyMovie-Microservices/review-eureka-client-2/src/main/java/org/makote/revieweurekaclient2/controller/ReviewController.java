package org.makote.revieweurekaclient2.controller;


import org.makote.revieweurekaclient2.dto.ReviewRoot;
import org.makote.revieweurekaclient2.entity.Review;
import org.makote.revieweurekaclient2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviewService/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public Review getOneById(@PathVariable String id) {
        System.out.println("id value::" + id);
        return reviewService.getOneById(id);
    }


    @GetMapping("/movies/{movieId}")
    public ReviewRoot getReviewForMovieId(@PathVariable int movieId) {
        System.out.println("movieId value::" + movieId);
        return reviewService.getReviewForMovieId(movieId);
    }


}
