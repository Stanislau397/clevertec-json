package ru.clevertec.json.data;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.clevertec.json.validator.FieldValidator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TestDataForFieldValidator {

    private int anInt;
    private int[] ints;

    private short aShort;
    private short[] aShorts;

    private byte aByte;
    private byte[] aBytes;

    private long aLong;
    private long[] aLongs;

    private boolean aBoolean;
    private boolean[] aBooleans;

    private float aFloat;
    private float[] aFloats;

    private double aDouble;
    private double[] aDoubles;

    private char aChar;

    private String aString;
    private String[] aStrings;

    private Character aCharacter;
    private Character[] aCharacters;

    private Movie movie;
    private Movie[] movies;

    private List<Movie> movieList;
    private Set<Movie> movieSet;
    private Queue<Movie> movieQueue;

    private Genre genre;
    private Genre[] genres;

    private Map<Integer, Integer> integerMap;
}
