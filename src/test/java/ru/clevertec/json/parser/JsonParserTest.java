package ru.clevertec.json.parser;

import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.clevertec.json.data.movie.Movie;
import ru.clevertec.json.data.movie.builder.MovieBuilder;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonParserTest {

    private JsonParser jsonParser;
    private Gson googleGson;

    @BeforeEach
    void setUp() {
        jsonParser = new JsonParser();
        googleGson = new Gson();
    }

    @AfterEach
    void tearDown() {
        jsonParser = null;
        googleGson = null;
    }

    @Test
    @SneakyThrows
    void checkToJsonShouldReturnJson() {
        Movie movie = MovieBuilder.build();
        String expectedJson = googleGson.toJson(movie);

        String actualJson = jsonParser.toJson(movie);
        
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    @SneakyThrows
    void checkFromJsonShouldBuildObject() {
        Movie movie = MovieBuilder.build();
        String json = jsonParser.toJson(movie);
        Movie expectedMovie = googleGson.fromJson(json, Movie.class);

        Movie actualMovie = (Movie) jsonParser.fromJson(json, Movie.class);

        assertThat(actualMovie).isEqualTo(expectedMovie);
    }
}