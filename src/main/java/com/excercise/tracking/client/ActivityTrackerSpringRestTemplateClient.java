package com.excercise.tracking.client;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.excercise.tracking.model.Activity;

public class ActivityTrackerSpringRestTemplateClient {

	RestTemplate restTemplate = new RestTemplate();

	public List<Activity> searchActivity(String param, String value) {
		URI url = UriBuilder.fromUri("http://localhost:8080/tracking-web/")
				.path("activities/search")
				.queryParam(param, value)
				.build();
		HttpHeaders headers = getHttpHeaders();

		HttpEntity<String> entity = new HttpEntity(headers);
		ParameterizedTypeReference<List<Activity>> responseType = new ParameterizedTypeReference<List<Activity>>() {};
		ResponseEntity<List<Activity>> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);
		return response.getBody();
	}


	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(org.springframework.http.MediaType.APPLICATION_JSON));
		headers.setContentType(org.springframework.http.MediaType.APPLICATION_JSON);
		return headers;
	}

}
