package org.makote.revieweurekaclient2.service;

import org.makote.revieweurekaclient2.dto.ReviewRoot;
import org.makote.revieweurekaclient2.entity.Review;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReviewService {

    RestTemplate restTemplate = new RestTemplate();

    final private static String REVIEW_BY_ID_URL = "https://api.themoviedb.org/3/review/{id}?api_key={api_key}";
    final private static String REVIEW_BY_MOVIE_ID_URL = "https://api.themoviedb.org/3/movie/{movieId}/reviews?api_key={api_key}";

    @Value("${api.key}")
    private String api_key;

    public List<Review> getAll() {

        throw new UnsupportedOperationException("Gel All not supported");
    }

    public Review getOneById(String id) {

        return restTemplate.getForObject(REVIEW_BY_ID_URL, Review.class, id, api_key);

    }

    public ReviewRoot getReviewForMovieId(int movieId) {
        System.out.println("url"+REVIEW_BY_MOVIE_ID_URL );
        System.out.println("reviewroot"+ ReviewRoot.class.toString());
        System.out.println("movieid"+movieId );
        System.out.println("apikey"+api_key );

        final Object reviewRoot1=restTemplate.getForObject("https://api.themoviedb.org/3/movie/238/reviews?api_key=1ec954df514f460f25c6f5bdfeedbb29",Object.class);
        System.out.println(reviewRoot1.toString());

        final ReviewRoot  reviewRoot=restTemplate.getForObject(REVIEW_BY_MOVIE_ID_URL, ReviewRoot.class, movieId, api_key);
        System.out.println(reviewRoot.toString());
        return reviewRoot;

    }
}