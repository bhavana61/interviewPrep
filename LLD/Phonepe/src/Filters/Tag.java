package LLD.Phonepe.src.Filters;

import LLD.Phonepe.src.Entities.Question;
import LLD.Phonepe.src.Interfaces.Filter;


import java.util.ArrayList;
import java.util.List;

public class Tag implements Filter<LLD.Phonepe.src.Enums.Tag> {
    @Override
    public List<Question> filter(List<Question> questions, LLD.Phonepe.src.Enums.Tag tag) {
        List<Question> result = new ArrayList<>();
        for (Question question : questions) {
            if (question.tag.equals(tag)) {
                result.add(question);
            }
        }
        return result;
    }
}
