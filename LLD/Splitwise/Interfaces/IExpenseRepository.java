package Splitwise.Interfaces;

import java.util.List;

import Entities.User;
import Splitwise.Entities.Expense;

public interface IExpenseRepository {
    public void saveExpense(Expense expense);
    public Expense getExpense(String expenseId);
    public List<Expense> getExpensesbyUser(User user);
}
