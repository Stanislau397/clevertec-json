package ru.clevertec.json.data.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Director {

    private long directorId;
    private String firstName;
    private String lastName;
    private Gender directorGender;
    private float height;
    private List<Genre> genreList;
}
