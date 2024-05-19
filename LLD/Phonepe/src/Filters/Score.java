package LLD.Phonepe.src.Filters;


import LLD.Phonepe.src.Entities.Question;
import LLD.Phonepe.src.Interfaces.Filter;

import java.util.*;

public class Score implements Filter<Integer> {
    @Override
    public List<Question> filter(List<Question> questions, Integer score) {
        Collections.sort(questions, (a, b) -> a.score - b.score);
        return questions;
    }
}