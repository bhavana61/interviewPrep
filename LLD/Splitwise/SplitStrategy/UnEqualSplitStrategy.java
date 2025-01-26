package Splitwise.SplitStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Splitwise.Entities.Split;
import Splitwise.Entities.User;

public class UnEqualSplitStrategy implements ISplitStrategy{

    @Override
    public List<Split> validateAndCalculateSplits(double amount, List<User> users, Map<User, Double> additionalData) {
        List<Split> splits = new ArrayList<>();
        double checkTotalAmount =0;
        for (User user : users) {
            checkTotalAmount += additionalData.getOrDefault(user, 0.0);
            splits.add(new Split(user, additionalData.getOrDefault(user, 0.0)));
        }
        if(checkTotalAmount != amount)
        throw new IllegalArgumentException("Invalid Expense. Please Verify");
        return splits;
    }

}
