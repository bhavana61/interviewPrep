package Splitwise.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.Split;
import Splitwise.Entities.User;

public class PercentageSplitStrategy implements ISplitStrategy{

    @Override
    public List<Split> validateAndCalculateSplits(double totalExpenseAmount, List<User> users, Map<User,Double> additinalSplitData) {
        List<Split> splits = new ArrayList<>();
        double checkTotalPercentage = 0;
        for(User user: users) {
            double percentage = additinalSplitData.getOrDefault(user, 0.0);
            checkTotalPercentage += percentage;
            splits.add(new Split(user, additinalSplitData.getOrDefault(user, (percentage/100)*100)));
        }
        if(checkTotalPercentage != 100)
        throw new IllegalArgumentException("Invalid Expense.Please verify");
        return splits;
    }
}
