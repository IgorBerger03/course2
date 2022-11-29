package com.example.course2.service;

import com.example.course2.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class MathQuestionRepository implements QuestionRepository {
    private final Set<Question> questionSet = new HashSet<>();

    @Override
    public Question add(Question question) {
        questionSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionSet;
    }
}
