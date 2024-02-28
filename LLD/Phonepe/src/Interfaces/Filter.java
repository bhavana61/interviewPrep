package Interfaces;

import Entities.Question;

import java.util.List;

public interface Filter<T> {
    public List<Question> filter(List<Question> questions, T sortkey);
}
