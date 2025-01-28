package Splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.Expense;
import Splitwise.Entities.Split;
import Splitwise.Entities.SplitType;
import Splitwise.Entities.User;
import Splitwise.SplitStrategy.ISplitStrategy;
import Splitwise.SplitStrategy.SplitStrategyFactory;


public class ExpenseManager {
    private Map<String, User> users;
    private Map<String, Map<String,Double>> balances;

    public ExpenseManager() {
        this.users = new HashMap<>();
        this.balances = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
        balances.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(String expenseId, String title, double expenseAmount, User payer, List<User> participants, SplitType splitType, Map<User,Double> aditionalData){
        ISplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);
        List<Split> splits = strategy.validateAndCalculateSplits(expenseAmount, participants, aditionalData);
        Expense expense = new Expense(expenseId, title, expenseAmount, payer, splitType,splits);
        UpdateBalances(expense);
    }

    //TO-DO:For group related changes can add method addExpenseGroup with group id, sent as attribute and updating the groups as well y maintaining a groups hashmap with list of expense in it
    //It (group )will be a bit complicated but need to have the strategy or way to do it
    
    private void UpdateBalances(Expense expense){
        User paidBy = expense.getPayer();
        List<Split> splits = expense.getSplitDetails();
        for (Split split : splits) {
            User owedBy = split.getUser();
            double amount = split.getAmount();

            // Update balances
            balances.get(owedBy.getUserId()).put(paidBy.getUserId(), balances.getOrDefault(owedBy.getUserId(), new HashMap<>()).getOrDefault(paidBy.getUserId(), 0.0) + amount);
            balances.get(paidBy.getUserId()).put(owedBy.getUserId(), balances.getOrDefault(paidBy.getUserId(), new HashMap<>()).getOrDefault(owedBy.getUserId(), 0.0) - amount);
        }
    }

    public void showBalances() {
        for (String user : balances.keySet()) {
            for (Map.Entry<String, Double> balance : balances.get(user).entrySet()) {
                if (balance.getValue() != 0) {
                    System.out.println(users.get(user).getName() + " owes " + users.get(balance.getKey()).getName() + ": " + balance.getValue());
                }
            }
        }
    }
}
