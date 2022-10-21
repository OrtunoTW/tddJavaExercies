package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AlignColumns {

    public static String replaceDollarBySpace (String text) { 
        String result = text.replace("$", " ");
        return result.replace("  ", "$ ");
    }

    public static List<String[]> main(String text) {
        List<String[]> wordMatrix = wordSetUp(text);
        align(wordMatrix);
        return wordMatrix;
    }

    private static void align(List<String[]> wordMatrix) {
        for (int columns = 0; columns < 2; columns ++) {
            int maxLength = getLongestLengthOfColumn(wordMatrix, columns);
            addBlankSpacesByColumn(wordMatrix, columns, maxLength);
        }
    }

    private static List<String[]> wordSetUp(String text) {
        String textReplaced = replaceDollarBySpace(text);
        var wordMatrix = createWordMatrix(textReplaced);
        return wordMatrix;
    }

    public static List<String[]> createWordMatrix(String textReplaced) {
        String[] allLines = textReplaced.split("\n");

        return Stream.of(allLines)
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }

    private static int getLongestLengthOfColumn(List<String[]> wordMatrix, int col) {
        int maxLength = 0;
        for (int row = 0; row < 2; row ++) {
            int wordLength = wordMatrix.get(row)[col].length();
            if (wordLength > maxLength) {
                maxLength = wordLength;
            }
        }
        return maxLength;
    }

    private static void addBlankSpacesByColumn(List<String[]> wordMatrix, int column, int maxLength) {
        for (int row = 0; row < 2; row ++) {
            int blankSpaces = maxLength - wordMatrix.get(row)[column].length();
            for (int cont = 0; cont <= blankSpaces; cont ++) {
                wordMatrix.get(row)[column] = wordMatrix.get(row)[column].concat(" ");
            }
        }
    }
}