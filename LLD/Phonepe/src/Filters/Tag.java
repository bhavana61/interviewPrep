package Filters;

import Entities.Question;
import Enums.SortKey;
import Interfaces.Filter;

import java.util.ArrayList;
import java.util.List;

public class Tag implements Filter<Enums.Tag>{
    @Override
    public List<Question> filter(List<Question> questions, Enums.Tag tag) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            if (question.tag.equals(tag)) {
                result.add(question);
            }
        }
        return result;
    }
}
