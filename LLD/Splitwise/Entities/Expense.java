package Splitwise.Entities;

import java.util.ArrayList;
import java.util.List;


public class Expense {
    private String expenseId;
    private String title;
    private double expenseAmount;
    private User payer;
    private SplitType splitType;
    private List<Split> splitDetails = new ArrayList<>();
    

    public Expense() {
    }
    public  Expense(String expenseId, String title, double expenseAmount, 
                                    User payer, SplitType splitType, List<Split> splitDetails) {

                this.expenseId = expenseId;
                this.title = title;
                this.expenseAmount = expenseAmount;
                this.payer = payer;
                this.splitType = splitType;
                this.splitDetails = splitDetails;
    }

    //getters and setters

    public void addSplit(Split split) {
        splitDetails.add(split);
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public User getPayer() {
        return payer;
    }

    public void setPayer(User payer) {
        this.payer = payer;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public void setSplitType(SplitType splitType) {
        this.splitType = splitType;
    }

    public List<Split> getSplitDetails() {
        return splitDetails;
    }

    public void setSplitDetails(List<Split> splitDetails) {
        this.splitDetails = splitDetails;
    }

}
