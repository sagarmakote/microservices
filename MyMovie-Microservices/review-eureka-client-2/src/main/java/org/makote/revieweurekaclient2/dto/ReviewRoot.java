package org.makote.revieweurekaclient2.dto;

import org.makote.revieweurekaclient2.entity.Author_details;
import org.makote.revieweurekaclient2.entity.Review;

import java.time.LocalDate;
import java.util.List;

public class ReviewRoot {

    private List<Review> results;

    public List<Review> getResults() {
        return results;
    }

    public void setResults(List<Review> results) {
        this.results = results;
    }

    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    private String author;

    private String content;

    private String created_at;
    private String updated_at;

    public String getAuthor() {
        return author;
    }



    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "ReviewRoot{" +
                "results=" + results +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}

