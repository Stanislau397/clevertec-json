package ru.clevertec.json.pattern;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class JsonPatternTest {


    @Test
    void checkJsonArrayPatternWithCurrentFieldAndNextFieldShouldContainParameters() {
        Pattern pattern =
                JsonPattern.jsonArrayPatternWithCurrentFieldAndNextField("name", "age");
        assertThat(pattern.pattern())
                .contains("name")
                .contains("age");
    }

    @Test
    void checkJsonArrayPatternWithoutNextFieldShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonArrayPatternWithoutNextField("name");
        assertThat(pattern.pattern())
                .contains("name");
    }

    @Test
    void checkJsonMapPatternWithNextFieldShouldContainParameters() {
        Pattern pattern =
                JsonPattern.jsonMapPatternWithNextField("name", "age");
        assertThat(pattern.pattern())
                .contains("name")
                .contains("age");
    }

    @Test
    void checkJsonMapPatternWithoutNextFieldShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonMapPatternWithoutNextField("name");
        assertThat(pattern.pattern())
                .contains("name");
    }

    @Test
    void checkJsonObjectsPatternWithNextFieldShouldContainParameters() {
        Pattern pattern =
                JsonPattern.jsonObjectsPatternWithNextField("name", "age");
        assertThat(pattern.pattern())
                .contains("name")
                .contains("age");
    }

    @Test
    void checkJsonObjectsPatternWithoutNextFieldShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonObjectsPatternWithoutNextField("name");
        assertThat(pattern.pattern())
                .contains("name");
    }

    @Test
    void checkJsonStringPatternShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonStringPattern("name");
        assertThat(pattern.pattern())
                .contains("name");
    }

    @Test
    void checkJsonNumbersPatternShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonNumbersPattern("name");
        assertThat(pattern.pattern())
                .contains("name");
    }

    @Test
    void checkJsonBooleansPatternShouldContainParameter() {
        Pattern pattern =
                JsonPattern.jsonBooleansPattern("name");
        assertThat(pattern.pattern())
                .contains("name");
    }
}