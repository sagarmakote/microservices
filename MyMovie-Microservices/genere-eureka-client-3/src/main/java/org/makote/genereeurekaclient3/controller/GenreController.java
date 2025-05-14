package org.makote.genereeurekaclient3.controller;

import org.makote.genereeurekaclient3.entity.Genre;
import org.makote.genereeurekaclient3.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genreMicroservice/v1/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("getAll")
    public List<Genre> getAll(){
        return genreService.getAll();
    }


    @GetMapping("/{id}")
    public  Genre  getById(@PathVariable int   id){
        System.out.println("id value is::"+id);
        return genreService.getById(id);
    }


}

