package com.example.demo.utils;

public class CsvUtils {

    public static final String CSV_DELIMITER = ";";

    public static String plainText(Object value) {
        return "\"\t" + value + "\"";
    }

    public static String escapeValue(
            String data,
            String delimiter
    ) {
        if (data.contains(delimiter) || data.contains("\"") || data.contains("'")) {
            return "\"" + data.replace("\"", "\"\"") + "\"";
        }
        return data;
    }

    public static String booleanRepresentation(boolean value) {
        return value ? "Да" : "Нет";
    }
}
