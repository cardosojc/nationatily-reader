package io.nationatily.adapter.output;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.uri.UriBuilder;
import io.nationatily.application.port.output.CountryRequestPort;
import jakarta.inject.Inject;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collections;

public class CountryApiRetriever implements CountryRequestPort {

    @Client("https://restcountries.com/v3.1/demonym/")
    @Inject
    HttpClient httpClient;

    @Override
    public String fetchCountryFromDemonym(String demonym) {
        String uri = UriBuilder.of("/{demonym}")
                .expand(Collections.singletonMap("demonym", demonym)).toString();
        var result = httpClient.toBlocking().retrieve(uri);
        JSONArray jsonArray = new JSONArray(result);
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        return ((JSONObject) jsonObject.get("name")).getString("common");
    }
}
