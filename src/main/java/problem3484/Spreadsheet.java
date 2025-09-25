package problem3484;

import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {

    private final Map<String, Integer> sheet;

    public Spreadsheet(int rows) {
        this.sheet = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        sheet.put(cell, value);
    }

    public void resetCell(String cell) {
        sheet.remove(cell);
    }

    public int getValue(String formula) {
        String[] split = formula.substring(1).split("\\+");
        String x = split[0], y = split[1];
        int result = 0;
        if (Character.isDigit(x.charAt(0))) {
            result += Integer.parseInt(x);
        } else {
            result += sheet.getOrDefault(x, 0);
        }
        if (Character.isDigit(y.charAt(0))) {
            result += Integer.parseInt(y);
        } else {
            result += sheet.getOrDefault(y, 0);
        }
        return result;
    }
}
