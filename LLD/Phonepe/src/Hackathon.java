import Entities.Question;
import Entities.Solution;
import Entities.User;
import Enums.DepartmentName;
import Enums.QuestionDifficulty;
import Enums.SortKey;
import Enums.Tag;
import Interfaces.Filter;

import java.util.*;

public class Hackathon {

    Map<Integer, Question> questions;
    Map<Integer, User> users;
    Map<Integer, List<Solution>> questionsToUsersSolvedMap;
    Map<Integer, List<Solution>> userToUsersSolvedMap;
    Map<Integer, Integer> userIdScore;
    PriorityQueue<Integer> leaderBoard;
    int questionId;
    int userId;

    public Hackathon() {
        this.questions = new HashMap<>();
        this.users = new HashMap<>();
        this.questionsToUsersSolvedMap = new HashMap<>();
        this.userToUsersSolvedMap = new HashMap<>();
        this.userIdScore = new HashMap<>();
        this.leaderBoard = new PriorityQueue<>((x, y) -> Integer.compare(userIdScore.get(y), userIdScore.get(x)));
        this.questionId = 1;
        this.userId = 1;
    }



    public void addProblem(String description, QuestionDifficulty difficulty, Tag tag, int score) {
        if (Helper.isNullOrEmpty(description)) {
            throw new InputMismatchException("Invalid Description");
        }
        if (score <= 0) {
            throw new InputMismatchException("Invalid score");
        }
        Question question = new Question(questionId, description, difficulty, score, tag);
        this.questionsToUsersSolvedMap.put(questionId, new ArrayList<>());
        this.questions.put(questionId++, question);
    }

    public void addUser(String name, DepartmentName departmentName) {
        if (Helper.isNullOrEmpty(name)) {
            throw new InputMismatchException("Invalid name");
        }

        User user = new User(userId, name, departmentName);
        this.userIdScore.put(userId, 0);
        this.userToUsersSolvedMap.put(userId, new ArrayList<>());
        this.users.put(userId++, user);
    }

    public <T> List<Question> fetchProblems(Map<SortKey, T> sortFilter) {
        List<Question> problems = new ArrayList<>(questions.values());
        for (Map.Entry<SortKey, T> entry : sortFilter.entrySet()) {
            Filter filter = FilterFactory.getFilterClass(entry.getKey());
            problems = filter.filter(problems, entry.getValue());
        }
        return problems;
    }

    public void solve(int userId, int questionId, int timeTaken) {
        if (userId <= 0 || questionId <= 0 || timeTaken <= 0) {
            throw new InputMismatchException("Invalid input");
        }
        Solution solution = new Solution(questionId, userId, timeTaken);

        this.questionsToUsersSolvedMap.get(questionId).add(solution);
        this.userToUsersSolvedMap.get(userId).add(solution);
        this.userIdScore.put(userId, this.userIdScore.get(userId) + this.questions.get(questionId).score);
        this.leaderBoard.remove(userId);
        this.leaderBoard.add(userId);
    }

    public List<Question> fetchSolvedProblems(int userId) {
        List<Question> solvedPrblems = new ArrayList<>();
        List<Solution> solvedList = this.userToUsersSolvedMap.get(userId);
        if (solvedList == null || solvedList.isEmpty()) return null;
        for (Solution solution : solvedList) {
            solvedPrblems.add(this.questions.get(solution.questionId));
        }
        return solvedPrblems;
    }

    public User getLeader() {
        if (this.leaderBoard.size() == 0) {
            return null;
        }
        return this.users.get(this.leaderBoard.peek());
    }

    public List<Question> getTopLikedProblems(int n, Tag tag) {
        List<Question> problems = new ArrayList<>(this.questions.values());
        Filter filter = FilterFactory.getFilterClass(SortKey.TAG);
        problems = filter.filter(problems, tag);
        Collections.sort(problems, (a, b) -> Integer.compare(this.questionsToUsersSolvedMap.get(b.questionId).size(),
                this.questionsToUsersSolvedMap.get(a.questionId).size()));
        return problems.subList(0, n);
    }
}
