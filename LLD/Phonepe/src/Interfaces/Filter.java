package LLD.Phonepe.src.Interfaces;


import LLD.Phonepe.src.Entities.Question;

import java.util.List;

public interface Filter<T> {
    public List<Question> filter(List<Question> questions, T sortkey);
}
