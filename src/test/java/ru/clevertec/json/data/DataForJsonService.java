package ru.clevertec.json.data;

import java.util.Map;

public class DataForJsonService {

    private String aString = "asd";
    private char aChar = '1';
    private int[] ints = new int[]{1, 2, 3, 4, 5};
    private Double[] doubles = new Double[]{1.23, 3.23};
    private Map<String, String> stringMap = Map.of("1", "str", "2", "str2");
    private Map<Integer, Integer> integerMap = Map.of(1, 2, 3, 4);
    private boolean aBoolean = true;
    private int anInt = 1;
    private double aDouble = 2.5;
}
