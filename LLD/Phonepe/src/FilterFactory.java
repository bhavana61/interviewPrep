import Enums.SortKey;
import Filters.Description;
import Filters.Difficulty;
import Filters.Score;
import Filters.Tag;
import Interfaces.Filter;

public class FilterFactory {

    public static Filter tag;
    public static Filter score;
    public static Filter description;
    public static Filter difficulty;

    public static Filter getFilterClass(SortKey sortKey) {
        switch (sortKey) {
            case TAG :
                if (tag == null) {
                    tag = new Tag();
                }
                return tag;
            case SCORE:
                if (score == null) {
                    score = new Score();
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
