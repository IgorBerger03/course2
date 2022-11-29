package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.ExaminerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Set;

@RestController
public class ExamController {
    private final ExaminerService service;

    @Autowired
    public ExamController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public Collection<Question> getQuestions(@RequestParam int amount) throws Exception {
        return service.getQuestions(amount);
    }
}
