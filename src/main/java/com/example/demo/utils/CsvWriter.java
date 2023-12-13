package com.example.demo.utils;


import com.example.demo.model.CsvFieldDescriptor;
import com.example.demo.model.exception.WritingCsvFileException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CsvWriter class provides functionality to write data into CSV format.
 * It supports custom delimiters, handles special characters, and is compatible with various data sources,
 * ideal for generating CSV files efficiently.
 */
public class CsvWriter {

    public static <T> StringWriter writeCsv(List<? extends CsvFieldDescriptor<T>> descriptors,
                                            List<T> dataDto) {
        StringWriter writer = new StringWriter();
        // for correct Cyrillic chars representation in Excel
        writer.write('\ufeff');
        String delimiter = CsvUtils.CSV_DELIMITER;
        writeHeader(descriptors, writer, delimiter);
        dataDto.forEach(dto -> CsvWriter.writeRow(descriptors, dto, writer, delimiter));

        return writer;
    }

    private static <T> void writeRow(List<? extends CsvFieldDescriptor<T>> descriptors,
                                     T data,
                                     Writer writer,
                                     String delimiter) {
        String csvString = descriptors.stream()
                .map(d -> d.valueGetter().apply(data))
                .collect(Collectors.joining(delimiter, "", "\n"));
        write(writer, csvString);
    }

    private static <T> void writeHeader(List<? extends CsvFieldDescriptor<T>> descriptors,
                                        Writer writer,
                                        String delimiter) {
        String header = descriptors.stream()
                .map(CsvFieldDescriptor::description)
                .collect(Collectors.joining(delimiter, "", "\n"));
        write(writer, header);
    }

    private static void write(Writer writer,
                              String row) {
        try {
            writer.write(row);
        } catch (IOException e) {
            throw new WritingCsvFileException();
        }
    }
}
