package org.makote.genereeurekaclient3.service;

import org.makote.genereeurekaclient3.entity.Genre;
import org.makote.genereeurekaclient3.entity.GenreRoot;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {
    private RestTemplate restTemplate = new RestTemplate();

    @Bean @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    private static final String GENRE_URL="https://api.themoviedb.org/3/genre/movie/list?api_key=1ec954df514f460f25c6f5bdfeedbb29";
    //https://api.themoviedb.org/3/genre/movie/list?api_key=1ec954df514f460f25c6f5bdfeedbb29
    @Value("1ec954df514f460f25c6f5bdfeedbb29")
    private String apikey;
    private List<Genre> genres=new ArrayList<>();

    public List<Genre> getAll(){
        System.out.println("inside getAll::");
        GenreRoot genreRoot=restTemplate.getForObject(GENRE_URL, GenreRoot.class);
        for (int i = 0; i <genreRoot.getGenres().size() ; i++) {
            Genre genre= genreRoot.getGenres().get(i);
            System.out.println(genre.toString());
        }

        return genreRoot.getGenres();
    }

    public Genre getById(int id){
        System.out.println("inside getById::"+id);
        GenreRoot genreRoot=restTemplate.getForObject(GENRE_URL, GenreRoot.class);
        genres=genreRoot.getGenres();


        if (genres==null || genres.isEmpty()){
            genres=getAll();
        }
        System.out.println(genres.stream()
                .filter(genre-> genre.getId()==id)
                .findFirst()
                .get().toString());
        return genres.stream()
                .filter(genre-> genre.getId()==id)
                .findFirst()
                .get();
    }

}
