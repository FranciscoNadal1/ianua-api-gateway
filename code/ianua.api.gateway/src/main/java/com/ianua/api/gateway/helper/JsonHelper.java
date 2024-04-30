package com.ianua.api.gateway.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> String serialize(T obj) throws JsonProcessingException {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();

            throw jsonProcessingException;
        }
    }

    public static <T> T deserialize(String json, Class<T> clazz) throws JsonProcessingException {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException jsonProcessingException) {
            jsonProcessingException.printStackTrace();

            throw jsonProcessingException;
        }
    }
}
