package e4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Calculator {
    /**
     * Public constructor of the calculator.
     */

    public ArrayList<String> operations;

    public static boolean isInOp(String value) {
        return IntStream.range(0, op.values().length).anyMatch(i -> op.values()[i].function.equals(value));
    }

    public static boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public enum op {
        sum("+"), sub("-"), mul("*"), div("/");

        private final String function;

        private op(String s) { function = s; }

        public String toString() { return this.function; }
    }

    public Calculator () { operations = new ArrayList<>(); }
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations () { operations.clear(); }
    /**
     * Add a new operation to the internal state of the calculator.
     * It is worth mentioning that the calculator behaves in an accumulative way ,
     * thus only first operation has two operands.
     * The rest of computations work with the accumulated value and only an extra
     * new operand. Second input value must be ignored if the operation does not
     * correspond to the first one.
     *
     * @param operation operation to add , as string , "+", "-", "*", "/".
     * @param values Operands of the new operation (one or two operands ).
     * Uses the varargs feature.
     * https :// docs.oracle.com/javase /8/ docs/technotes/guides/language/varargs.html
     * @throws IllegalArgumentException If the operation does not exist.
     */

    public void addOperation(String operation, float ... values) {

        if (operations.size() == 0)
            operations.add(String.valueOf(values[0]));

        if (isInOp(operation))
            operations.add(operation);
        else {
            cleanOperations();
            throw new IllegalArgumentException(operation + "is not an operation");
        }

        if (operations.size() == 2)
            operations.add(String.valueOf(values[1]));
        else
            operations.add(String.valueOf(values[0]));

    }
    /**
     * Execute the set of operations of the internal state of the calculator.
     * Once execution is finished , internal state (operands and operations)
     * is restored (EVEN if exception occurs ).
     * This calculator works with "Batches" of operations.
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     * (division by zero)
     */
    public float executeOperations () {

        float result = 0;

        for (int i = 1; i < operations.size(); i+=2) {

            if (Objects.equals(operations.get(i), op.sum.function))
                result = Float.parseFloat(operations.get(i-1)) + Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.sub.function))
                result = Float.parseFloat(operations.get(i-1)) - Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.mul.function))
                result = Float.parseFloat(operations.get(i-1)) * Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.div.function)) {
                if (Float.parseFloat(operations.get(i+1)) == 0) {
                    cleanOperations();
                    throw new ArithmeticException("dividing a number by 0 is not allowed in this program");
                }
                result = Float.parseFloat(operations.get(i-1)) / Float.parseFloat(operations.get(i+1));
            }

            operations.set(i+1, String.valueOf(result));

        }

        cleanOperations();
        return result;
    }
    /**
     * Current internal state of calculator is printed
     * FORMAT:
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES: JUnit tests
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString () {

        StringBuilder str = new StringBuilder("[STATE:");
        String str2 = "";
        float f;

        for (int i = 0; i < operations.size(); i++) {

            str2 = operations.get(i);

            if (i <= 1) {

                if (isNumeric(str2))
                    str.append("[").append(operations.get(i + 1)).append("]");
                else
                    str.append(operations.get(i - 1)).append("_");
            } else {

                if (isNumeric(str2))
                    str.append(str2);
                else
                    str.append("[").append(str2).append("]");
            }
        }

        str.append("]");
        return str.toString();
    }
}