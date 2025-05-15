package org.makote.actoreurekaclient4.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.makote.actoreurekaclient4.entity.Actor;

import java.util.List;

public class ActorRoot {

    private int id;
    @JsonProperty("cast")
    private List<Actor> actors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}