package LLD.Phonepe.src.Filters;

import LLD.Phonepe.src.Entities.Question;
import LLD.Phonepe.src.Interfaces.Filter;

import java.util.Collections;
import java.util.List;

public class Description implements Filter<String> {
    @Override
    public List<Question> filter(List<Question> questions, String description) {
        Collections.sort(questions, (a, b) -> a.description.compareTo(b.description));
        return questions;
    }
}