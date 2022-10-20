package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AlignColumnsTest {

    @Test
    void shouldReturnSameInputWhenDollarIsNotPresent() {
        // Given
        var input = "Unacadenacambiada";
        var expected = "Unacadenacambiada";

        // When
        var actual = AlignColumns.replaceDollarBySpace(input);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTwoSeparatedWordsWhenDollarIsPresentInBetween() {
        // Given
        var input = "Cadena$cambiada";
        var expected = "Cadena cambiada";

        // When
        var actual = AlignColumns.replaceDollarBySpace(input);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFiveSeparatedWordsWhenDollarIsPresentInBetween() {
        // Given
        var input = "Soy$una$cadena$de$cinco$palabras";
        var expected = "Soy una cadena de cinco palabras";

        // When
        var actual = AlignColumns.replaceDollarBySpace(input);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnTwoPhrasesAlignedByColumnsWhenThereIsABreakLine() {
        // Given
        var input = "Cadena$cambiada\nSoy$cadena";
        var expected = "Cadena cambiada\nSoy    cadena";

        // When
        var actual = AlignColumns.align(input);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnWordMatrixWithForAllTheLines() {
        // Given
        var input = "Cadena cambiada\nSoy cadena";
        List<String[]> expected = Arrays.asList(new String[]{"Cadena", "cambiada"}, new String[]{"Soy","cadena"});

        // When
        var actual = AlignColumns.createWordMatrix(input);

        // Then
        Assertions.assertAll(
                IntStream.range(0, actual.size())
                        .mapToObj(i -> () -> Assertions.assertArrayEquals(expected.get(i),
                                actual.get(i)))
        );
    }

    @Test
    void shouldReturnOneDollarSignWhenThereAreTwoDollarsContiguous() {
        // Given
        var input = "Cuesta$20$$todo";
        var expected = "Cuesta 20$ todo";

        // When
        var actual = AlignColumns.replaceDollarBySpace(input);

        // Then
        assertEquals(expected, actual);
    }



}
