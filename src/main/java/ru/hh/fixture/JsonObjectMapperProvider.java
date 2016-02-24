package ru.hh.fixture;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonObjectMapperProvider implements ContextResolver<ObjectMapper> {

  final ObjectMapper defaultObjectMapper;

  public JsonObjectMapperProvider() {
    defaultObjectMapper = createDefaultMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    return defaultObjectMapper;
  }

  private static ObjectMapper createDefaultMapper() {
    final ObjectMapper result = new ObjectMapper();
    Jackson8Module module = new Jackson8Module();
    module.addStringSerializer(LocalDate.class, LocalDate::toString);
    module.addStringSerializer(LocalDateTime.class, LocalDateTime::toString);
    result.registerModule(module);
    result.configure(SerializationFeature.INDENT_OUTPUT, true);

    return result;
  }
}
