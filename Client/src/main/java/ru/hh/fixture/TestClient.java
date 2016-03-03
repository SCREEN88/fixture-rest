package ru.hh.fixture;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import com.google.common.net.HttpHeaders;
import com.google.common.net.MediaType;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider;
import static java.util.Collections.emptyMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import ru.hh.fixture.beans.UserData;
import ru.hh.fixture.beans.resume.ResumeData;
import ru.hh.jclient.common.AbstractClient;
import ru.hh.jclient.common.HttpClientBuilder;
import ru.hh.jclient.common.HttpClientContext;
import ru.hh.jclient.common.JResource;
import ru.hh.jclient.common.ResultWithStatus;
import ru.hh.jclient.common.util.storage.SingletonStorage;

public class TestClient extends AbstractClient {
  private static final String PATH = "/fx";

  private final String baseHost;
  private final ObjectMapper jsonMapper;

  protected TestClient(String host, HttpClientBuilder http) {
    super(host, PATH, http);
    this.baseHost = host;
    this.jsonMapper = new ObjectMapper();
    jsonMapper.findAndRegisterModules();
//    jsonMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
    jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//    jsonMapper.configure(DeserializationFeature.UNWRAP_SINGLE_VALUE_ARRAYS, true);
//    jsonMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
//    jsonMapper.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
//    jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//    SimpleModule simpleModule = new SimpleModule();
//    simpleModule.addDeserializer(List.class, new CustomJsonDeserializer());
//    jsonMapper.registerModule(simpleModule);
  }

  @JResource("/rest/user")
  public CompletableFuture<ResultWithStatus<UserData>> testClient() throws JsonProcessingException {
    RequestBuilder request = post(url("/rest/user"))
        .setBody(jsonMapper.writeValueAsString(new UserData()))
        .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.JSON_UTF_8.toString());
    return http.with(request.build()).expectJson(jsonMapper, UserData.class).resultWithStatus();
  }

  @JResource("/rest/resume")
  public CompletableFuture<ResultWithStatus<ResumeData>> testResume() {
    RequestBuilder request = get(jerseyUrl("/rest/resume"));
    return http.with(request.build()).expectJson(jsonMapper, ResumeData.class).resultWithStatus();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException, JsonProcessingException {
    AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
        .setConnectTimeout(2000)
        .setMaxConnections(-1)
        //.setUserAgent("fixture")
        .build();
    //MDCCopy.doWithoutContext(() -> new AsyncHttpClient(new NettyAsyncHttpProvider(config), config));
    TestClient client = new TestClient("http://localhost:7373", new HttpClientBuilder(new AsyncHttpClient(new NettyAsyncHttpProvider(config), config),
        ImmutableSet.of("http://localhost"), new SingletonStorage<>(new HttpClientContext(emptyMap(), emptyMap(), TestRequestDebug::instance)
    )));
    client.testClient().get().get().get();
    //client.testResume().get().get().get();
  }
}
