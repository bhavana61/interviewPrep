package Splitwise.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.User;
import Splitwise.Entities.Expense;
import Splitwise.Interfaces.IExpenseRepository;

public class InMemoryExpenseRepository implements IExpenseRepository{

    private Map<String, Expense> expenses = new HashMap<>();
    private Map<String, List<Expense>> userExpenses = new HashMap<>();

    @Override
    public void saveExpense(Expense expense) {
        expenses.put(expense.getExpenseId(), expense);

        //add user expenses
        if(!userExpenses.containsKey(expense.getPayer().getUserId())) {
            userExpenses.put(expense.getPayer().getUserId(), new ArrayList<>());
        }
        userExpenses.get(expense.getPayer().getUserId()).add(expense);
    }

    @Override
    public Expense getExpense(String expenseId) {
        return expenses.get(expenseId);
    }

    @SuppressWarnings("unlikely-arg-type")
    @Override
    public List<Expense> getExpensesbyUser(User user) {
        return userExpenses.get(user.getUserId());
    }

}
