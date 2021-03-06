package ru.hh.fixture;

import com.ning.http.client.AsyncHttpClientConfig;
import com.ning.http.client.Request;
import com.ning.http.client.Response;
import java.util.Optional;
import ru.hh.jclient.common.RequestDebug;
import ru.hh.jclient.common.exception.ResponseConverterException;

public class TestRequestDebug implements RequestDebug {
  private static final RequestDebug DISABLED_REQUEST_DEBUG = new TestRequestDebug();

  @Override
  public void onRequest(AsyncHttpClientConfig config, Request request, Optional<?> requestBodyEntity) {

  }

  @Override
  public Response onResponse(AsyncHttpClientConfig config, Response response) {
    return response;
  }

  @Override
  public void onResponseConverted(Optional<?> result) {

  }

  @Override
  public void onClientProblem(Throwable t) {

  }

  @Override
  public void onConverterProblem(ResponseConverterException e) {

  }

  @Override
  public void onProcessingFinished() {

  }

  @Override
  public void addLabel(String label) {

  }
  public static RequestDebug instance() {
    return DISABLED_REQUEST_DEBUG;
  }
}
