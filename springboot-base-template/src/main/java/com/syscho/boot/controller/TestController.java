package com.syscho.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/data")
public class TestController {


    @GetMapping("/{id}")
    public String getById(@PathVariable("id") long id) {
        return null;
    }


    @GetMapping
    public List get() {
        return null;
    }

    @PostMapping
    public Object save(@RequestBody @Valid Object payload) {
        return null;
    }

    @PutMapping
    public Object update(@RequestBody @Valid Object payload) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        return null;
    }
}
