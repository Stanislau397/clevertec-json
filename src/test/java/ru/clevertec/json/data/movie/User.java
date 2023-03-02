package ru.clevertec.json.data.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class User {

    private int userId;
    private String userName;
    private Character[] password;
    private Set<String> emails;
    private Gender gender;
    private Boolean isAdult;
    private char aChar;
}
