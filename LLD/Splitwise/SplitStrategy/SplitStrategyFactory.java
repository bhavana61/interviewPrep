package Splitwise.SplitStrategy;

import Splitwise.Entities.SplitType;

public class SplitStrategyFactory {
    public static ISplitStrategy getStrategy(SplitType splitType) {
        switch(splitType){
            case EQUALLY :
                return new EqualSplitStrategy();
            case UNEQUALLY:
                return new UnEqualSplitStrategy();
            case BYPERCENTAGE :
                return new PercentageSplitStrategy();
            default :
            throw new IllegalArgumentException("Invalid Strategy Type");
        }
    }
}
