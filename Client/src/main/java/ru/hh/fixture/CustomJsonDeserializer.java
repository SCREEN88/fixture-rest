package ru.hh.fixture;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomJsonDeserializer<T> extends JsonDeserializer<List<T>> {


  @Override
  public List<T> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    return null;
  }

  @Override
  public List<T> getNullValue(DeserializationContext ctxt) throws JsonMappingException {
    return new ArrayList();
  }
}