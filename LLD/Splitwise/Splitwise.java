package Splitwise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.SplitType;
import Splitwise.Entities.User;
import Splitwise.Entities.SplitType;

public class Splitwise {

    public void demo() {
        ExpenseManager expenseManager = new ExpenseManager();

        User user1 = new User("u1", "Alice", "alice@example.com");
        User user2 = new User("u2", "Bob", "bob@example.com");
        User user3 = new User("u3", "Charlie", "charlie@example.com");

        expenseManager.addUser(user1);
        expenseManager.addUser(user2);
        expenseManager.addUser(user3);

        List<User> participants = Arrays.asList(user1, user2, user3);

        Map<User, Double> additionalData = new HashMap<>();
        additionalData.put(user1, 50.0);
        additionalData.put(user2, 30.0);
        additionalData.put(user3, 20.0);

        expenseManager.addExpense("e1", "Lunch", 300, user1, participants, SplitType.EQUALLY, additionalData);

        expenseManager.showBalances();
    }
}
