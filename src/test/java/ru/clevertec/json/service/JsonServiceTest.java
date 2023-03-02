package ru.clevertec.json.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.clevertec.json.data.DataForJsonService;
import ru.clevertec.json.parser.JsonParser;

import java.lang.reflect.Field;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonServiceTest {

    private JsonService jsonService;
    private JsonParser jsonParser;
    private DataForJsonService dataForJsonService;

    @BeforeEach
    void setUp() {
        jsonService = new JsonService();
        jsonParser = new JsonParser();
        dataForJsonService = new DataForJsonService();
    }

    @AfterEach
    void tearDown() {
        jsonService = null;
    }

    @Test
    @SneakyThrows
    void checkFindArraysInJsonShouldReturn2() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> arraysMap = jsonService.findArraysInJson(json, fields);

        assertThat(arraysMap.size()).isEqualTo(2);
    }

    @Test
    @SneakyThrows
    void checkFindMapsInJsonShouldReturn2() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> maps = jsonService.findMapsInJson(json, fields);

        assertThat(maps.size()).isEqualTo(2);
    }

    @Test
    @SneakyThrows
    void checkFindObjectsInJsonShouldReturn2() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> objects = jsonService.findObjectsInJson(json, fields);

        assertThat(objects.size()).isEqualTo(2);
    }

    @Test
    @SneakyThrows
    void checkFindStringsAndCharsShouldReturn2() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> stringsAndChars = jsonService.findStringsAndCharsInJson(json, fields);

        assertThat(stringsAndChars.size()).isEqualTo(2);
    }

    @Test
    @SneakyThrows
    void checkFindBooleansShouldReturn1() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> booleans = jsonService.findBooleansInJson(json, fields);

        assertThat(booleans.size()).isEqualTo(1);
    }

    @Test
    @SneakyThrows
    void checkFindNumbersShouldReturn2() {
        String json = jsonParser.toJson(dataForJsonService);
        Class<?> clazz = dataForJsonService.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Map<String, String> numbersMap = jsonService.findNumbersInJson(json, fields);

        assertThat(numbersMap.size()).isEqualTo(2);
    }
}