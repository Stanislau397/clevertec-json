package ru.clevertec.json.service;

import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.clevertec.json.data.TestDataForArrayService;

import java.lang.reflect.Field;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ArrayServiceTest {

    private ArrayService arrayService;

    @BeforeEach
    void setUp() {
        arrayService = new ArrayService();
    }

    @AfterEach
    void tearDown() {
        arrayService = null;
    }

    @Nested
    class BuildArrayBasedOnFieldType {

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnDoubleField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("doubles");
            String doublesAsString = "5.5,1.2,3.1,5.2";

            Object doublesArray = arrayService.buildArrayBasedOnFieldType(field, doublesAsString);

            assertThat(doublesArray).isInstanceOf(double[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnFloatField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("floats");
            String floatsAsString = "5.5,1.2,3.1,5.2";

            Object floatsArray = arrayService.buildArrayBasedOnFieldType(field, floatsAsString);

            assertThat(floatsArray).isInstanceOf(float[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnEnumField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("genres");
            String enumAsString = "\"" + "HORROR" + "\"" + ",\"" + "ACTION" + "\"";

            Object enumsArray = arrayService.buildArrayBasedOnFieldType(field, enumAsString);

            assertThat(enumsArray).isInstanceOf(Enum[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnBooleanField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("booleans");
            String booleansAsString = "\"" + "false" + "\"" + ",\"" + "true" + "\"";

            Object booleansArray = arrayService.buildArrayBasedOnFieldType(field, booleansAsString);

            assertThat(booleansArray).isInstanceOf(boolean[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnIntegerField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("ints");
            String intsAsString = "5,1,3,5";

            Object intsArray = arrayService.buildArrayBasedOnFieldType(field, intsAsString);

            assertThat(intsArray).isInstanceOf(int[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnByteField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("bytes");
            String bytesAsString = "5,1,3,5";

            Object bytesArray = arrayService.buildArrayBasedOnFieldType(field, bytesAsString);

            assertThat(bytesArray).isInstanceOf(byte[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnShortField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("shorts");
            String shortsAsString = "5,1,3,5";

            Object shortArray = arrayService.buildArrayBasedOnFieldType(field, shortsAsString);

            assertThat(shortArray).isInstanceOf(short[].class);
        }

        @Test
        @SneakyThrows
        void checkShouldBuildArrayBasedOnLongField() {
            TestDataForArrayService testDataForArrayService = new TestDataForArrayService();
            Class<?> clazz = testDataForArrayService.getClass();
            Field field = clazz.getDeclaredField("longs");
            String longsAsString = "5,1,3,5";

            Object longsArray = arrayService.buildArrayBasedOnFieldType(field, longsAsString);

            assertThat(longsArray).isInstanceOf(long[].class);
        }
    }
}