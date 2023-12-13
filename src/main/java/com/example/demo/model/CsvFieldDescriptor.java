package com.example.demo.model;

import java.util.function.Function;

public interface CsvFieldDescriptor<T> {

    String description();

    Function<T, String> valueGetter();
}
