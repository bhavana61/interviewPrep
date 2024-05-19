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

    String minute = expandField(fields[0], 0, 59);
    String hour = expandField(fields[1], 0, 23);
    String dayOfMonth = expandField(fields[2], 1, 31);
    String month = expandField(fields[3], 1, 12);
    String dayOfWeek = expandField(fields[4], 0, 6);
    String command = fields[5];

        System.out.println("minute\t\t" + minute);
        System.out.println("hour\t\t" + hour);
        System.out.println("day of month\t" + dayOfMonth);
        System.out.println("month\t\t" + month);
        System.out.println("day of week\t" + dayOfWeek);
        System.out.println("command\t\t" + command);
}

    // */15 0 1,15 * 1-5 /usr/bin/find

    private static String expandField(String field, int min, int max) {
        List<Integer> result = new ArrayList<>();

        if (field.equals("*")) {
            for (int i = min; i <= max; i++) {
                result.add(i);
            }
        } else if (field.contains("/")) {
            String[] split = field.split("/");
            int step = Integer.parseInt(split[1]);
            if (split[0].equals("*")) {
                for (int i = min; i <= max; i += step) {
                    result.add(i);
                }
            } else {
                int start = Integer.parseInt(split[0]);
                for (int i = start; i <= max; i += step) {
                    result.add(i);
                }
            }
        } else if (field.contains(",")) {
            String[] split = field.split(",");
            for (String s : split) {
                if (s.contains("-")) {
                    result.addAll(parseRange(s, min, max));
                } else {
                    result.add(Integer.parseInt(s));
                }
            }
        } else if (field.contains("-")) {
            result.addAll(parseRange(field, min, max));
        } else {
            result.add(Integer.parseInt(field));
        }

        StringBuilder resultStr = new StringBuilder();
        for (int i : result) {
            resultStr.append(i).append(" ");
        }

        return resultStr.toString().trim();
    }

    private static List<Integer> parseRange(String range, int min, int max) {
        List<Integer> result = new ArrayList<>();
        String[] split = range.split("-");
        int start = Integer.parseInt(split[0]);
        int end = Integer.parseInt(split[1]);
        for (int i = start; i <= end; i++) {
            result.add(i);
        }
        return result;
    }
}
