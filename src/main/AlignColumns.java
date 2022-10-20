package main;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AlignColumns {

    public static String replaceDollarBySpace (String text) { 
        String result = text.replace("$", " ");
        return result.replace("  ", "$ ");
    }

    public static String align(String text) {
        String textReplaced = replaceDollarBySpace(text);
        var wordMatrix = createWordMatrix(textReplaced);

        /*
        1 - Renplazamos los dolares por espacio
        2 - Creamos una matrix con cada palabra y cada línea
        3 - Tenemos que buscar la palabra más grande por coluna
        4 - Añadir espacio para se quedar de acuerdo a el length de la palabra más grande
        5 - Generar una string con todas las líneas
        * */

        return "a";
    }

    public static List<String[]> createWordMatrix(String textReplaced) {
        String[] allLines = textReplaced.split("\n");

        return Stream.of(allLines)
                .map(line -> line.split(" "))
                .collect(Collectors.toList());
    }
}