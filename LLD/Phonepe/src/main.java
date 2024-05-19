package LLD.Phonepe.src;

import LLD.Phonepe.src.Entities.Question;
import LLD.Phonepe.src.Entities.User;
import LLD.Phonepe.src.Enums.DepartmentName;
import LLD.Phonepe.src.Enums.QuestionDifficulty;
import LLD.Phonepe.src.Enums.Tag;

import java.util.HashMap;
import java.util.List;

public class main {
    public static void main(String[] args){
        Hackathon hackathon = new Hackathon();
        hackathon.addProblem("Question 1", QuestionDifficulty.EASY, Tag.ARRAYS, 10);
        hackathon.addProblem("Question 2", QuestionDifficulty.EASY, Tag.STRING, 20);
        hackathon.addProblem("Question 3", QuestionDifficulty.EASY, Tag.TREES, 30);
        hackathon.addProblem("Question 4", QuestionDifficulty.MEDIUM, Tag.ARRAYS, 30);
        hackathon.addProblem("Question 5", QuestionDifficulty.MEDIUM, Tag.ARRAYS, 30);
        hackathon.addProblem("Question 6", QuestionDifficulty.MEDIUM, Tag.TREES, 30);
        hackathon.addProblem("Question 7", QuestionDifficulty.MEDIUM, Tag.TREES, 30);
        hackathon.addProblem("Question 8", QuestionDifficulty.MEDIUM, Tag.TREES, 30);
        hackathon.addProblem("Question 9", QuestionDifficulty.MEDIUM, Tag.TREES, 45);

        hackathon.addUser("User 1", DepartmentName.DEVELOPMENT);
        hackathon.addUser("User 2", DepartmentName.DEVELOPMENT);
        hackathon.addUser("User 3", DepartmentName.TESTING);
        hackathon.addUser("User 4", DepartmentName.TESTING);
        hackathon.addUser("User 5", DepartmentName.TESTING);
        hackathon.addUser("User 6", DepartmentName.TESTING);
        hackathon.addUser("User 7", DepartmentName.TESTING);
        hackathon.addUser("User 8", DepartmentName.DEVELOPMENT);
        hackathon.addUser("User 9", DepartmentName.DEVELOPMENT);
        hackathon.addUser("User 10", DepartmentName.DEVELOPMENT);

        hackathon.solve(1, 9, 2);
        hackathon.solve(1, 2, 3);
        hackathon.solve(1, 3, 2);
        hackathon.solve(3, 1, 3);
        hackathon.solve(4, 1, 2);
        hackathon.solve(4, 2, 3);
        hackathon.solve(4, 3, 2);
        hackathon.solve(4, 4, 3);

        List<Question> filteredProblems = hackathon.fetchProblems(new HashMap<>());
        System.out.println(filteredProblems.size());
        User user = hackathon.getLeader();
        System.out.println(user);
        System.out.println(hackathon.getTopLikedProblems(2, Tag.TREES));
        List<Question> solvedProblemsBy1 = hackathon.fetchSolvedProblems(4);
        System.out.println(solvedProblemsBy1.size());
    }
}
