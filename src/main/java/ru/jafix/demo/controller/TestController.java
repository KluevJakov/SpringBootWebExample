package ru.jafix.demo.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.jafix.demo.model.Company;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    /*
    Реализовать 2 ручки:
    - POST /companies
    пример тела запроса:
    {
        "name": "Haulmont",
        "employers": 200
    }
    добавлять элемент в storage

     */

    private List<Company> storage = new ArrayList<>();

    @GetMapping("/companies")
    public List<Company> getCompanies() {
        return storage;
    }

    @PostMapping("/companies")
    public void createCompany(@RequestBody Company company) {
        storage.add(company);
    }

}
