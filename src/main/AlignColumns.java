package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AlignColumns {

    public static String replaceDollarBySpace (String text) { 
        String result = text.replace("$", " ");
        return result.replace("  ", "$ ");
    }

    public static List<String[]> align(String text) {
        String textReplaced = replaceDollarBySpace(text);
        var wordMatrix = createWordMatrix(textReplaced);

        for (int col = 0; col < 2; col ++) {
            int maxLength = 0;
            for (int row = 0; row < 2; row ++) {
                int wordLength = wordMatrix.get(col)[row].length();
                if (wordLength > maxLength) {
                    maxLength = wordLength;
                }
            }

            for (int row2 = 0; row2 < 2; row2 ++) {
                int blankSpaces = (maxLength - 1) - wordMatrix.get(col)[row2].length();
                for (int cont = 0; cont < blankSpaces; cont ++) {
                    wordMatrix.get(col)[row2].concat(" ");
                }
            }
        }

        /*
        DONE 1 - Renplazamos los dolares por espacio
        DONE 2 - Creamos una matrix con cada palabra y cada línea
        3 - Tenemos que buscar la palabra más grande por columna
        4 - Añadir espacio para se quedar de acuerdo a el length de la palabra más grande
        5 - Generar una string con todas las líneas
        * */

        return wordMatrix;
    }

    public static List<String[]> createWordMatrix(String textReplaced) {
        String[] allLines = textReplaced.split("\n");

        return Stream.of(allLines)
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }
}