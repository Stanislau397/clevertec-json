package ru.clevertec.json.data.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class Actor {

    private byte actorId;
    private String actorFirstName;
    private String actorLastName;
    private Gender actorGender;
    private Genre[] genres;
    private boolean married;
}
