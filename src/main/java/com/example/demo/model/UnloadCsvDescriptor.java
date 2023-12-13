package com.example.demo.model;

import com.example.demo.model.dto.TaskDTO;
import com.example.demo.utils.CsvUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public enum UnloadCsvDescriptor implements CsvFieldDescriptor<TaskDTO> {
    TASK_ID("Id", TaskDTO::getId),
    TASK_NAME("Имя", TaskDTO::getName),
    TASK_DESCRIPTION("Описание", TaskDTO::getDescription);

    private final String description;
    private final Function<TaskDTO, String> valueGetter;

    UnloadCsvDescriptor(String description, Function<TaskDTO, ?> valueGetter) {
        this.description = description;
        this.valueGetter = value -> CsvUtils.escapeValue(
                Objects.toString(valueGetter.apply(value), ""),
                CsvUtils.CSV_DELIMITER
        );
    }

    <T> UnloadCsvDescriptor(
            String description,
            Function<TaskDTO, T> valueGetter,
            Function<T, String> valueFormatter
    ) {
        this.description = description;
        this.valueGetter = value -> Optional.ofNullable(valueGetter.apply(value))
                .map(valueFormatter)
                .orElse("");
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Function<TaskDTO, String> valueGetter() {
        return valueGetter;
    }

    public static final List<UnloadCsvDescriptor> COMMON = List.of(
            UnloadCsvDescriptor.TASK_ID,
            UnloadCsvDescriptor.TASK_NAME,
            UnloadCsvDescriptor.TASK_DESCRIPTION
    );
}
