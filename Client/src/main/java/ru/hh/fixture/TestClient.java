package ru.hh.fixture;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableSet;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.RequestBuilder;
import com.ning.http.client.providers.netty.NettyAsyncHttpProvider;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import ru.hh.jclient.common.AbstractClient;
import ru.hh.jclient.common.HttpClientBuilder;
import ru.hh.jclient.common.HttpClientContext;
import ru.hh.jclient.common.JResource;
import ru.hh.jclient.common.ResultWithStatus;
import ru.hh.jclient.common.util.storage.SingletonStorage;

public class TestClient extends AbstractClient {
  private static final String PATH = "/rest";

  private final String baseHost;
  private final ObjectMapper jsonMapper;

  protected TestClient(String host, HttpClientBuilder http) {
    super(host, PATH, http);
    this.baseHost = host;
    this.jsonMapper = new ObjectMapper();
    jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  }

  @JResource("/hello/json")
  public CompletableFuture<ResultWithStatus<UserData>> testClient() {
    RequestBuilder request = get(jerseyUrl("/hello/json"));
    return http.with(request.build()).expectJson(jsonMapper, UserData.class).resultWithStatus();
  }

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    AsyncHttpClientConfig config = new AsyncHttpClientConfig.Builder()
        .setConnectTimeout(3000)
        .setMaxConnections(10)
        .setUserAgent("fixture")
        .build();
    //MDCCopy.doWithoutContext(() -> new AsyncHttpClient(new NettyAsyncHttpProvider(config), config));
    TestClient client = new TestClient("http://localhost:8080", new HttpClientBuilder(new AsyncHttpClient(new NettyAsyncHttpProvider(config), config),
        ImmutableSet.of("http://localhost"), new SingletonStorage<>((Supplier<HttpClientContext>) () -> new HttpClientContext(Collections.emptyMap(), Collections.emptyMap(),
        TestRequestDebug::new
    ))));
    client.testClient().get().get().get();
  }

}
