package org.makote.movieeurekaclient1.entity;

import java.util.List;

public class GenreRoot {


    private List<Genre> genres;

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "GenreRoot{" +
                "genres=" + genres +
                '}';
    }
}