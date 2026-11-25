package ru.jafix.demo.model.books;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookSearchResponse {

    private Integer start;

    @JsonProperty("num_found")
    private Integer numFound;

    private List<BookDto> docs;
}