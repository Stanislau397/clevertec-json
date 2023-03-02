package ru.clevertec.json.validator;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ru.clevertec.json.data.TestDataForFieldValidator;

import java.lang.reflect.Field;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class FieldValidatorTest {

    @Nested
    class IsFieldAStringTest {

        @Test
        @SneakyThrows
        void checkIsFieldAStringShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aString");

            boolean condition = FieldValidator.isFieldAString(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldAStringShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBoolean");

            boolean condition = FieldValidator.isFieldAString(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldACharTest {

        @Test
        @SneakyThrows
        void checkIsFieldACharShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aChar");

            boolean condition = FieldValidator.isFieldAChar(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldACharShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aString");

            boolean condition = FieldValidator.isFieldAChar(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldACharacterTest {

        @Test
        @SneakyThrows
        void checkIsFieldACharacterShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aCharacter");

            boolean condition = FieldValidator.isFieldACharacter(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldACharacterShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aString");

            boolean condition = FieldValidator.isFieldACharacter(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentACharacterTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentACharacterShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aCharacters");

            boolean condition = FieldValidator.isFieldComponentACharacter(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentACharacterShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentACharacter(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldACharacterArrayTest {

        @Test
        @SneakyThrows
        void checkIsFieldACharacterArrayShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aCharacters");

            boolean condition = FieldValidator.isFieldACharacterArray(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldACharacterArrayShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldACharacterArray(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldAnObjectOfOtherCustomClassTest {

        @Test
        @SneakyThrows
        void checkIsFieldAnObjectOfOtherCustomClassShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movie");

            boolean condition = FieldValidator.isFieldAnObjectOfOtherCustomClass(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldAnObjectOfOtherCustomClassShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldAnObjectOfOtherCustomClass(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAnObjectOfOtherCustomClass {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAnObjectOfOtherCustomClassShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movies");

            boolean condition = FieldValidator.isFieldComponentAnObjectOfOtherCustomClass(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAnObjectOfOtherCustomClassShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAnObjectOfOtherCustomClass(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldACollectionTest {

        @Test
        @SneakyThrows
        void checkIsFieldACollectionShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldACollection(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldACollectionShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movies");

            boolean condition = FieldValidator.isFieldACollection(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldAnArrayTest {

        @Test
        @SneakyThrows
        void checkIsFieldAnArrayShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movies");

            boolean condition = FieldValidator.isFieldAnArray(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldAnArrayShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldAnArray(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldAMapTest {

        @Test
        @SneakyThrows
        void checkIsFieldAMapShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("integerMap");

            boolean condition = FieldValidator.isFieldAMap(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldAMapShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldAMap(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldAnEnumTest {

        @Test
        @SneakyThrows
        void checkIsFieldAnEnumShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("genre");

            boolean condition = FieldValidator.isFieldAnEnum(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldAnEnumShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldAnEnum(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsArrayComponentAPrimitiveTest {

        @Test
        @SneakyThrows
        void checkIsArrayComponentAPrimitiveShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("ints");

            boolean condition = FieldValidator.isArrayComponentAPrimitive(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsArrayComponentAPrimitiveShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isArrayComponentAPrimitive(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentACharTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentACharShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aCharacters");

            boolean condition = FieldValidator.isFieldComponentAChar(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentACharShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAChar(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentTypeAnEnumTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentTypeAnEnumShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("genres");

            boolean condition = FieldValidator.isFieldComponentTypeAnEnum(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentTypeAnEnumShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentTypeAnEnum(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAnIntTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAnIntShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("ints");

            boolean condition = FieldValidator.isFieldComponentAnInt(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAnIntShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAnInt(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentALongTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentALongShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aLongs");

            boolean condition = FieldValidator.isFieldComponentALong(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentALongShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentALong(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentADoubleTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentADoubleShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aDoubles");

            boolean condition = FieldValidator.isFieldComponentADouble(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentADoubleShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentADouble(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAFloatTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAFloatShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aFloats");

            boolean condition = FieldValidator.isFieldComponentAFloat(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAFloatShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAFloat(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAShortTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAShortShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aShorts");

            boolean condition = FieldValidator.isFieldComponentAShort(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAShortShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAShort(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAByteTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAByteShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBytes");

            boolean condition = FieldValidator.isFieldComponentAByte(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAByteShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAByte(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentABooleanTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentABooleanShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBooleans");

            boolean condition = FieldValidator.isFieldComponentABoolean(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentABooleanShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentABoolean(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldABooleanTest {

        @Test
        @SneakyThrows
        void checkIsFieldABooleanShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBoolean");

            boolean condition = FieldValidator.isFieldABoolean(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldABooleanShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aByte");

            boolean condition = FieldValidator.isFieldABoolean(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldComponentAStringTest {

        @Test
        @SneakyThrows
        void checkIsFieldComponentAStringShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aStrings");

            boolean condition = FieldValidator.isFieldComponentAString(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldComponentAStringShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBooleans");

            boolean condition = FieldValidator.isFieldComponentAString(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldANumberTest {

        @Test
        @SneakyThrows
        void checkIsFieldANumberShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("anInt");

            boolean condition = FieldValidator.isFieldANumber(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldANumberShouldReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBoolean");

            boolean condition = FieldValidator.isFieldANumber(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldTypeAListTest {

        @Test
        @SneakyThrows
        void checkIsFieldTypeAListShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldTypeAList(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldTypeAListReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("aBooleans");

            boolean condition = FieldValidator.isFieldTypeAList(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldTypeASetTest {

        @Test
        @SneakyThrows
        void checkIsFieldTypeASetShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieSet");

            boolean condition = FieldValidator.isFieldTypeASet(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldTypeASetReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldTypeASet(field);

            assertThat(condition).isFalse();
        }
    }

    @Nested
    class IsFieldTypeAQueueTest {

        @Test
        @SneakyThrows
        void checkIsFieldTypeAQueueShouldReturnTrue() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieQueue");

            boolean condition = FieldValidator.isFieldTypeAQueue(field);

            assertThat(condition).isTrue();
        }

        @Test
        @SneakyThrows
        void checkIsFieldTypeAQueueReturnFalse() {
            TestDataForFieldValidator testDataForFieldValidator = new TestDataForFieldValidator();
            Class<?> clazz = testDataForFieldValidator.getClass();
            Field field = clazz.getDeclaredField("movieList");

            boolean condition = FieldValidator.isFieldTypeAQueue(field);

            assertThat(condition).isFalse();
        }
    }
}