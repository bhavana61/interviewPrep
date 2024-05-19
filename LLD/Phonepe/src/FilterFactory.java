package LLD.Phonepe.src;


import LLD.Phonepe.src.Enums.SortKey;
import LLD.Phonepe.src.Enums.Tag;
import LLD.Phonepe.src.Filters.Description;
import LLD.Phonepe.src.Filters.Difficulty;
import LLD.Phonepe.src.Interfaces.Filter;

public class FilterFactory {

    public static Filter tag;
    public static Filter score;
    public static Filter description;
    public static Filter difficulty;

    public static Filter getFilterClass(SortKey sortKey) {
        switch (sortKey) {
            case TAG :
                if (tag == null) {
                    //tag = new Tag();
                }
                return tag;
            case SCORE:
                if (score == null) {
                   // score = new Filter.Score();
                }
                return score;
            case DESCRIPTION:
                if (description == null) {
                    description = new Description();
                }
                return description;
            case DIFFICULTY:
                if (difficulty == null) {
                    difficulty = new Difficulty();
                }
                return difficulty;
            default:
                break;
        }
        return null;
    }
}
