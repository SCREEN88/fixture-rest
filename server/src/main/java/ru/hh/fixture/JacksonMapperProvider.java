package ru.hh.fixture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JacksonMapperProvider implements ContextResolver<ObjectMapper> {
  final ObjectMapper defaultObjectMapper;

  public JacksonMapperProvider() {
    defaultObjectMapper = createDefaultMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return defaultObjectMapper;
  }

  private static ObjectMapper createDefaultMapper() {
    final ObjectMapper result = new ObjectMapper();
    result.findAndRegisterModules();
    result.configure(SerializationFeature.INDENT_OUTPUT, false); //set true for pretty print
    return result;
  }
}