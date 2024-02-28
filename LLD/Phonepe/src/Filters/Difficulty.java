package Filters;

import Entities.Question;
import Interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

public class Difficulty implements Filter<Enums.QuestionDifficulty> {
    @Override
    public List<Question> filter(List<Question> questions, Enums.QuestionDifficulty difficulty) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            if (question.difficulty.equals(difficulty)) {
                result.add(question);
            }
        }
        return result;
    }
}