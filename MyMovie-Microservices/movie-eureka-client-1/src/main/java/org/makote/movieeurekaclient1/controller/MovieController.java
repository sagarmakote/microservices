package org.makote.movieeurekaclient1.controller;


import org.makote.movieeurekaclient1.entity.Movie;
import org.makote.movieeurekaclient1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movieService/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/getAll")
    public List<Movie> getAll(){
        return movieService.getAll();
    }

    @GetMapping("/movie/{id}")
    public Movie getOneById(@PathVariable  int id){
        System.out.println("MovieController id value::" +id);
        return  movieService.getOneByID(id);

    }


}
