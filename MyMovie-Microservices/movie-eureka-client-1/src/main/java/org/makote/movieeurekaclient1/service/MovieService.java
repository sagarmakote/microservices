package org.makote.movieeurekaclient1.service;


import org.makote.movieeurekaclient1.entity.Genre;
import org.makote.movieeurekaclient1.entity.GenreRoot;
import org.makote.movieeurekaclient1.entity.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private RestTemplate restTemplate =new RestTemplate();
    private List<Genre> genres=new ArrayList<>();

    private static final String GET_MOVIE_BY_ID_URL="https://api.themoviedb.org/3/movie/{id}?api_key={api_key}";
    private static final String GET_GENRE_BY_ID_URL="http://localhost:8091/api/genreMicroservice/v1/genres/";

    private static final String GENRE_URL="https://api.themoviedb.org/3/genre/movie/list?api_key=1ec954df514f460f25c6f5bdfeedbb29";

    @Value("1ec954df514f460f25c6f5bdfeedbb29")
    private String api_key;

    public List<Movie> getAll(){
        throw new UnsupportedOperationException("This operation not supported");
    }

    public Movie getOneByID(int movieId){
        System.out.println("MovieService movieId value::" +movieId);
        Movie movie1 = restTemplate.getForObject(GET_MOVIE_BY_ID_URL,Movie.class,movieId,api_key);
        for (int i = 0; i <movie1.getGenreIds().size() ; i++) {
            Genre genre= getById(movie1.getGenreIds().get(i));

            System.out.println("genre.getName()::"+genre.getName());
        }
        return movie1;

    }

//    public Genre getGenreByID(int genreId){
//        System.out.println("MovieService genreId value::" +genreId);
//        return restTemplate.getForObject(GET_GENRE_BY_ID_URL,Genre.class,genreId,api_key);
//
//    }

    public Genre getById(int id){
//        System.out.println("inside getById::"+id);
        //System.out.println("inside GET_GENRE_BY_ID_URL::"+GET_GENRE_BY_ID_URL+id);
        GenreRoot genreRoot=restTemplate.getForObject(GET_GENRE_BY_ID_URL+id, GenreRoot.class);
//        System.out.println("genreRoot.toString()::"+genreRoot.toString());
        genres=genreRoot.getGenres();

        genreRoot=restTemplate.getForObject(GENRE_URL, GenreRoot.class);
        for (int i = 0; i <genreRoot.getGenres().size() ; i++) {
            Genre genre= genreRoot.getGenres().get(i);
//            System.out.println(genre.toString());
        }

//        System.out.println(genreRoot.getGenres().stream()
//                .filter(genre-> genre.getId()==id)
//                .findFirst()
//                .get().toString());
        return genreRoot.getGenres().stream()
                .filter(genre-> genre.getId()==id)
                .findFirst()
                .get();
    }

}
