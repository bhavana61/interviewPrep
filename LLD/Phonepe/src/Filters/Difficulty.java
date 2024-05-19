package LLD.Phonepe.src.Filters;

import LLD.Phonepe.src.Entities.Question;
import LLD.Phonepe.src.Interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

public class Difficulty implements Filter<LLD.Phonepe.src.Enums.QuestionDifficulty> {
    @Override
    public List<Question> filter(List<Question> questions, LLD.Phonepe.src.Enums.QuestionDifficulty difficulty) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            if (question.difficulty.equals(difficulty)) {
                result.add(question);
            }
        }
        return result;
    }
}