package ru.clevertec.json.data.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Movie {

    private short movieId;
    private char[] title;
    private List<Genre> movieGenres;
    private String[] posters;
    private Double budget;
    private double grossWorldWide;
    private int runTime;
    private Set<Director> directors;
    private List<Actor> actors;
    private Comment[] comments;
}
