package org.makote.actoreurekaclient4.controller;

import org.makote.actoreurekaclient4.entity.Actor;
import org.makote.actoreurekaclient4.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actor/Service/v1/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public List<Actor> getAll(){
        return actorService.getAll();
    }


    @GetMapping("/{id}")
    public Actor getOneById(@PathVariable int id){
        return actorService.getOneById(id);
    }

    @GetMapping("/movies/{movieId}")
    public List<Actor> getActorByMovieId(@PathVariable int movieId){
        return actorService.getActorByMovieId(movieId);
    }

}

