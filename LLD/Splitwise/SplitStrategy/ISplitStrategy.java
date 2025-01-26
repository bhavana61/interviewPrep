package Splitwise.SplitStrategy;

import java.util.List;
import java.util.Map;

import Splitwise.Entities.Split;
import Splitwise.Entities.User;

public interface ISplitStrategy {
public List<Split> validateAndCalculateSplits(double totalExpenseAmount,List<User> users, Map<User, Double> additinalSplitData);
}
