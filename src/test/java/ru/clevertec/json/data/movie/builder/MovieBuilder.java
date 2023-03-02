package ru.clevertec.json.data.movie.builder;

import ru.clevertec.json.data.movie.Actor;
import ru.clevertec.json.data.movie.Comment;
import ru.clevertec.json.data.movie.Director;
import ru.clevertec.json.data.movie.Gender;
import ru.clevertec.json.data.movie.Genre;
import ru.clevertec.json.data.movie.Movie;
import ru.clevertec.json.data.movie.User;

import java.util.List;
import java.util.Set;

public class MovieBuilder {

    public static Movie build() {
        User user = User.builder()
                .userId(12345)
                .userName("Stanislau")
                .password(new Character[]{'l', 'd', 'k', '1', '2', '3'})
                .gender(Gender.MALE)
                .emails(Set.of("asd@gmail.com", "bvs@gmail.com"))
                .isAdult(true)
                .aChar('p')
                .build();
        Comment comment = Comment.builder()
                .commentId(1L)
                .user(user)
                .text("Some comment")
                .build();
        Actor actor = Actor.builder()
                .actorId((byte) 1)
                .actorFirstName("Tom")
                .actorLastName("Hanks")
                .actorGender(Gender.MALE)
                .married(true)
                .genres(new Genre[]{Genre.ACTION, Genre.HORROR, Genre.FANTASY})
                .build();
        Director firstDirector = Director.builder()
                .directorId(3L)
                .firstName("AJjdsajkjkdakj")
                .lastName("sadkjjkadsjk")
                .directorGender(Gender.FEMALE)
                .height(1.75f)
                .genreList(List.of(Genre.ACTION, Genre.SCI_FI))
                .build();
        Director secondDirector = Director.builder()
                .directorId(2L)
                .firstName("Aiiadjiuiqw")
                .lastName("iqoewoiioq")
                .height(1.80f)
                .directorGender(Gender.MALE)
                .genreList(List.of(Genre.HORROR, Genre.FANTASY))
                .build();
        Movie movie = Movie.builder()
                .movieId((short) 1)
                .budget(21334.12)
                .movieGenres(List.of(Genre.ACTION, Genre.HORROR, Genre.SCI_FI, Genre.FANTASY))
                .grossWorldWide(2341.12)
                .posters(new String[]{"oiadsioiodasoi.jpg", "kjadsjkkjadsjk.jpg", "iqweiioqewo.png", "ahudsh.jpg"})
                .actors(List.of(actor, actor, actor, actor, actor, actor, actor, actor, actor, actor))
                .directors(Set.of(firstDirector, secondDirector))
                .runTime(200)
                .title(new char[]{'S', 'o', 'm', 'e', 't', 'i', 't', 'l', 'e'})
                .comments(new Comment[]{comment, comment, comment, comment, comment, comment, comment})
                .build();
        return movie;
    }
}
