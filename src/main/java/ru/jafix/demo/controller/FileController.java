package ru.jafix.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class FileController {

    @PostMapping(
            path = "/upload1",
            consumes = "application/octet-stream"
    )
    public void upload1(
            @RequestBody byte[] data,
            @RequestHeader("Filename") String filename
    ) throws UnsupportedEncodingException {

        String decodedFilename = URLDecoder.decode(filename, "UTF-8");

        try (FileOutputStream fos = new FileOutputStream(decodedFilename)) {

            fos.write(data);

        } catch (FileNotFoundException fnf) {
            System.out.println("Ошибка открытия файла: " + fnf.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    @PostMapping(
            path = "/upload2",
            consumes = "multipart/form-data"
    )
    public void upload2(@RequestParam("file1") MultipartFile multipartFile) {

        try (FileOutputStream fos = new FileOutputStream(multipartFile.getOriginalFilename())) {

            fos.write(multipartFile.getBytes());

        } catch (FileNotFoundException fnf) {
            System.out.println("Ошибка открытия файла: " + fnf.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
