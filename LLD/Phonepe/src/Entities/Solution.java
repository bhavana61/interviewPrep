package Entities;

public class Solution {
    public int questionId;
    public int userId;
    public int timeTaken;

    public Solution(int questionId, int userId, int timeTaken) {
        this.questionId = questionId;
        this.timeTaken = timeTaken;
        this.userId = userId;
    }
}
