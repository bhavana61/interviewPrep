package LLD.ExpressionParse;

import java.util.ArrayList;
import java.util.List;

public class CronExpressionParser {
    public static void main(String[] args) {
    //        if (args.length != 1) {
//            System.out.println("Usage: java CronExpressionParser <cron_expression>");
//            return;
//        }

    String s = "*/15 0 1,15 * 1-5 /usr/bin/find";

    //String[] fields = args[0].split("\\s+");
    String[] fields = s.split("\\s+");
        if (fields.length != 6) {
        System.out.println("Invalid cron expression");
        return;
    }

    //Done - Should handle the case where the cron expression when other invalid expression is given as input and send an ImproperFormat expression
    //Should handle dates of different months differently.

    String minute = expandField(fields[0], 0, 59);
    String hour = expandField(fields[1], 0, 23);
    String dayOfMonth = expandField(fields[2], 1, 31);
    String month = expandField(fields[3], 1, 12);
    String dayOfWeek = expandField(fields[4], 1, 7);
    String command = fields[5];

        System.out.println("minute\t\t" + minute);
        System.out.println("hour\t\t" + hour);
        System.out.println("day of month\t" + dayOfMonth);
        System.out.println("month\t\t" + month);
        System.out.println("day of week\t" + dayOfWeek);
        System.out.println("command\t\t" + command);
}

    // */15 0 1,15 * 1-5 /usr/bin/find

    static String expandField(String field, int min, int max) {
        List<Integer> result = new ArrayList<>();

        if (field.equals("*")) {
            for (int i = min; i <= max; i++) {
                validateExpandField(i,min,max);
                result.add(i);
            }
        } else if (field.contains("/")) {
            String[] split = field.split("/");
            int step = Integer.parseInt(split[1]);
            if (split[0].equals("*")) {
                for (int i = min; i <= max; i += step) {
                    validateExpandField(i,min,max);
                    result.add(i);
                }
            } else {
                int start = Integer.parseInt(split[0]);
                for (int i = start; i <= max; i += step) {
                    validateExpandField(i,min,max);
                    result.add(i);
                }
            }
        } else if (field.contains(",")) {
            String[] split = field.split(",");
            for (String s : split) {
                if (s.contains("-")) {
                    result.addAll(parseRange(s, min, max));
                } else {
                    validateExpandField(Integer.parseInt(s),min,max);
                    result.add(Integer.parseInt(s));
                }
            }
        } else if (field.contains("-")) {
            result.addAll(parseRange(field, min, max));
        } else {
            validateExpandField(Integer.parseInt(field),min,max);
            result.add(Integer.parseInt(field));
        }

        StringBuilder resultStr = new StringBuilder();
        for (int i : result) {
            validateExpandField(i,min,max);
            resultStr.append(i).append(" ");
        }

        return resultStr.toString().trim();
    }

    private static List<Integer> parseRange(String range, int min, int max) {
        List<Integer> result = new ArrayList<>();
        String[] split = range.split("-");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);

        //validate the range
        validateExpandField(start,min,max);
        validateExpandField(end,min,max);

        for (int i = start; i <= end; i++) {
            validateExpandField(i,start,end);
            result.add(i);
        }
        return result;
    }

    static void validateExpandField(int i, int min, int max){
        if(i<min || i>max)
            throw new IllegalArgumentException("Invalid value");
    }
}
