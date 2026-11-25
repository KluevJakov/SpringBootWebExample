package ru.jafix.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.jafix.demo.model.books.BookSearchResponse;

@Service
@RequiredArgsConstructor
public class IntegrationService {

    private final RestTemplate restTemplate;

    public void sendRequest() {


        ResponseEntity<BookSearchResponse> response =
                restTemplate.getForEntity(
                        "https://openlibrary.org/search.json?lang=ru&author=pushkin",
                BookSearchResponse.class);

        if (response.getStatusCode() == HttpStatusCode.valueOf(200)) {

        }

        System.out.println(response);
    }

}
