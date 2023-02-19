package es.pokemon.pokedex.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneraInserts {
    public static void main(String[] args) {
        File directory = new File("CsvToInsert");
        File[] listOfFiles = directory.listFiles();
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            String tableName = file.getName().replace(".csv", "");
            System.out.println("\n --------------- " + tableName + " --------------- \n");
            StringBuilder values;
            StringBuilder fieldsNames = new StringBuilder();
            List<String> inserts = new ArrayList<>();
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                int counter = 0;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    values = new StringBuilder();
                    for (String field : fields) {
                        if (counter == 0) {
                            fieldsNames.append(field).append(", ");
                        } else {
                            if (isNumeric(field)) {
                                values.append(field).append(", ");
                            } else values.append("\"").append(field).append("\", ");
                        }
                    }

                    if (counter == 0)
                        fieldsNames = new StringBuilder(fieldsNames.substring(0, fieldsNames.length() - 2));

                    if (!values.isEmpty()) values = new StringBuilder(values.substring(0, values.length() - 2));

                    if (counter != 0)
                        inserts.add("INSERT INTO " + tableName + "(" + fieldsNames + ") values(" + values + ");");
                    counter++;
                }
                inserts.forEach(System.out::println);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean isNumeric(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
