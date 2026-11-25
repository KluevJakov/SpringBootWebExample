package ru.jafix.demo.model.books;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    @JsonProperty("cover_i")
    private Integer coverId;

    @JsonProperty("has_fulltext")
    private Boolean hasFulltext;

    @JsonProperty("edition_count")
    private Integer editionCount;

    private String title;

    @JsonProperty("author_name")
    private List<String> authorNames;

    @JsonProperty("first_publish_year")
    private Integer firstPublishYear;

    private String key;

    private List<String> ia;

    @JsonProperty("author_key")
    private List<String> authorKeys;

    @JsonProperty("public_scan_b")
    private Boolean publicScan;
}