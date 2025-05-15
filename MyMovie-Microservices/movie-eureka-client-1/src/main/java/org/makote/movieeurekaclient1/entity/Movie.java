package org.makote.movieeurekaclient1.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Movie {

    private int id;
    private String title;
    @JsonProperty("original_title")
    private String originalTitle;

    private long budget;

    private String overview;
    private double popularity;

    @JsonProperty("release_Date")
    private String releaseDate;
    private long revenue;

    private String tagline;

    @JsonProperty("vote_Average")
    private Double voteAverage;

    @JsonProperty("vote_Count")
    private Double voteCount;

    private List<Integer> genreIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Double getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Double voteCount) {
        this.voteCount = voteCount;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    @JsonProperty("genres")
    public void setGenreIds(List<Map<String,String>> genreIds) {

        final List<Integer> genres=genreIds.stream().map(item->item.get("id"))
                .map(idString->Integer.valueOf(idString))
                .collect(Collectors.toList());


        this.genreIds = genres;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", originalTitle='" + originalTitle + '\'' +
                ", budget=" + budget +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", releaseDate='" + releaseDate + '\'' +
                ", revenue=" + revenue +
                ", tagline='" + tagline + '\'' +
                ", voteAverage=" + voteAverage +
                ", voteCount=" + voteCount +
                ", genreIds=" + genreIds +
                '}';
    }
}