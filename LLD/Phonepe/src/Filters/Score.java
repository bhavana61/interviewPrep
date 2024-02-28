package Filters;

import Entities.Question;
import Interfaces.Filter;

import java.util.*;

public class Score implements Filter<Integer> {
    @Override
    public List<Question> filter(List<Question> questions, Integer score) {
        Collections.sort(questions, (a, b) -> a.score - b.score);
        return questions;
    }
}