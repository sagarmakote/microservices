package org.makote.actoreurekaclient4.service;


import org.makote.actoreurekaclient4.dto.ActorRoot;
import org.makote.actoreurekaclient4.entity.Actor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    private RestTemplate  restTemplate =new RestTemplate();
    //https://api.themoviedb.org/3/person/504?api_key=1ec954df514f460f25c6f5bdfeedbb29
    private static final String ACTOR_BY_ID_URL="https://api.themoviedb.org/3/person/{id}?api_key={api_key}";

    //https://api.themoviedb.org/3/movie/278/credits?api_key=1ec954df514f460f25c6f5bdfeedbb29
    private static final String ACTOR_BY_MOVIE_ID="https://api.themoviedb.org/3/movie/{movieId}/credits?api_key={api_key}";
    @Value("${api.key}")
    private String api_key;


    public List<Actor> getAll() {
        throw new UnsupportedOperationException("THis operation not supported");
    }

    public Actor getOneById(int id) {
        System.out.println("id value::"+id);
        return restTemplate.getForObject(ACTOR_BY_ID_URL,Actor.class,id, api_key);
    }

    public List<Actor> getActorByMovieId(int movieId) {
        System.out.println("movieId value::"+movieId);
        final ActorRoot actroRoot=restTemplate.getForObject(ACTOR_BY_MOVIE_ID, ActorRoot.class,movieId, api_key);
        return actroRoot.getActors();
    }
}
