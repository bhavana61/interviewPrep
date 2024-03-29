package Entities;

import Enums.QuestionDifficulty;
import Enums.Tag;

public class Question {
    public int questionId;
    public String description;
    public QuestionDifficulty difficulty;
    public Tag tag;
    public int score;

    public Question (int id, String description, QuestionDifficulty questionDifficulty, int score, Tag tag) {
        this.questionId = id;
        this.description = description;
        this.difficulty = questionDifficulty;
        this.score = score;
        this.tag = tag;
    }
}
