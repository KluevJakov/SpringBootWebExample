package ru.jafix.demo.enums;

import org.springframework.http.MediaType;

import java.util.List;

public enum MediaTypes {
    JPG(MediaType.IMAGE_JPEG, List.of("jpg", "jpeg")),
    PNG(MediaType.IMAGE_PNG, List.of("png")),
    PDF(MediaType.APPLICATION_PDF, List.of("pdf")),
    DEFAULT(MediaType.APPLICATION_OCTET_STREAM, List.of());

    MediaType mediaType;
    List<String> extensions;

    MediaTypes(MediaType mediaType, List<String> extensions) {
        this.mediaType = mediaType;
        this.extensions = extensions;
    }

    public static MediaType getMediaTypeByExtension(String extension) {
        MediaTypes[] mediaTypes = values();

        for (MediaTypes mt : mediaTypes) {
            if (mt.extensions.contains(extension.toLowerCase())) {
                return mt.mediaType;
            }
        }

        return DEFAULT.mediaType;
    }

}
