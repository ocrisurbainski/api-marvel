package br.com.urbainski.api.marvel.serializer;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    private final DateTimeFormatter dateTimeFormatter;

    public LocalDateTimeSerializer() {

        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'hh:mm:ss");
    }

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {

        if (localDateTime == null) {

            jsonGenerator.writeNull();
        }

        try {

            String result = localDateTime.format(dateTimeFormatter);

            jsonGenerator.writeString(result);
        } catch (DateTimeException ex) {

            jsonGenerator.writeNull();
        }
    }

    @Override
    public Class<LocalDateTime> handledType() {

        return LocalDateTime.class;
    }

}