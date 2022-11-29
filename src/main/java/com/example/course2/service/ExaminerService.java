package com.example.course2.service;

import com.example.course2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws Exception;
}
