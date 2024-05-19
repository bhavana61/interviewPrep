package LLD.ExpressionParse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CronExpressionParserTest {
    @Test
    public void testExpandField() {
        CronExpressionParser parser = new CronExpressionParser();

        // Test with asterisk
        String result1 = parser.expandField("*", 0, 59);
        assertEquals("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59", result1);

        // Test with step value
        String result2 = parser.expandField("*/18", 0, 59);
        assertEquals("0 18 36 54", result2);

        // Test with comma-separated values
        String result3 = parser.expandField("1,15", 0, 59);
        assertEquals("1 15", result3);

        // Test with range
        String result4 = parser.expandField("1-5", 0, 59);
        assertEquals("1 2 3 4 5", result4);

        // Test with single value
        String result5 = parser.expandField("5", 0, 59);
        assertEquals("5", result5);

        // Test with invalid value
        try {
            String result6 = parser.expandField("60", 0, 59);
        } catch (Exception e) {
            assertEquals("Invalid value", e.getMessage());
        }
        // Test with invalid value
        try {
            String result7 = parser.expandField("1,61", 0, 59);
        } catch (Exception e) {
            assertEquals("Invalid value", e.getMessage());
        }
        //Test with invalid value
        try {
            String result8 = parser.expandField("1-5,7,10,50-61", 0, 59);
        } catch (Exception e) {
            assertEquals("Invalid value", e.getMessage());
        }
    }
}
