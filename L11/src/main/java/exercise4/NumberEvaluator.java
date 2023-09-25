package exercise4;

public class NumberEvaluator implements Evaluator {
    /** Returns true, if s contains a valid integer or decimal number. */
    @Override
    public boolean isValid(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ignored) {}
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ignored) {}
        return false;
    }

}
