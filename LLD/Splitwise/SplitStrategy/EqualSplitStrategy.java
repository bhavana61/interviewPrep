package Splitwise.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.Split;
import Splitwise.Entities.User;

public class EqualSplitStrategy implements ISplitStrategy{

    @Override
    public List<Split> validateAndCalculateSplits(double amount, List<User> users, Map<User, Double> additionalData) {
        List<Split> splits = new ArrayList<>();

        if(users.size() == 0)
        throw new IllegalArgumentException("Invalid Expense. Please verify");
        
        double splitAmount = amount / users.size();
        for (User user : users) {
            splits.add(new Split(user, splitAmount));
        }
        return splits;
    }
}
