package io.nationatily.adapter.output;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.nationatily.application.port.output.CountryRequestPort;
import jakarta.inject.Singleton;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;


@Singleton
public class CountryApiRetriever implements CountryRequestPort {
    private final URI uri;
    private final HttpClient httpClient;

    public CountryApiRetriever(HttpClient httpClient) {
        this.uri = UriBuilder.fromUri("https://restcountries.com/v3.1/demonym/").build();
        this.httpClient = httpClient;
    }

    @Override
    public String fetchCountryFromDemonym(String demonym) {

        HttpRequest<?> request =  HttpRequest.GET(uri);

        return null;
    }
}
