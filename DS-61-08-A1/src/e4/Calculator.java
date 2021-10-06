package e4;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class Calculator {
    /**
     * Public constructor of the calculator.
     */

    public ArrayList<String> operations; //The list that stores the elements of the queue of the calculator
    //True is the string is contained in the future built enum
    public static boolean isInOp(String value) { return IntStream.range(0, op.values().length).anyMatch(i -> op.values()[i].function.equals(value)); }
    //Detects if a string is numeric
    public static boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) { return false; }
    }

    //Enum defining the possible operations in the calculator
    public enum op {
        sum("+"), sub("-"), mul("*"), div("/");
        private final String function;
        op(String s) { function = s; }
        public String toString() { return this.function; } //Constructor
    }

    public Calculator () { operations = new ArrayList<>(); } //Constructor of a new calculator
    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations () { operations.clear(); } //Cleans all the elements in the operation list
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

    //Adds an operation to the operations list with its corresponding digit(s)
    public void addOperation(String operation, float ... values) {

        if (operations.size() == 0)
            operations.add(String.valueOf(values[0])); //If the list is empty, we add the first of the TWO values

        if (isInOp(operation))
            operations.add(operation); //Add operation if correct
        else {
            cleanOperations(); //Exception if the operation doesn't exist
            throw new IllegalArgumentException(operation + " is not an operation");
        }

        if (operations.size() == 2) //If the list was empty at the beginning
            operations.add(String.valueOf(values[1])); //Add the second argument to the list
        else //If not
            operations.add(String.valueOf(values[0])); //Add the only argument

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
    //Executes the set of operations stored in the operations list
    public float executeOperations () {

        float result = 0;

        for (int i = 1; i < operations.size(); i+=2) { //stays in the operand places in the list
            //takes the previous element in the list as the first element in the operation and the next element as the second one

            if (Objects.equals(operations.get(i), op.sum.function)) //Sum
                result = Float.parseFloat(operations.get(i-1)) + Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.sub.function)) //Subtract
                result = Float.parseFloat(operations.get(i-1)) - Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.mul.function)) //Multiplication
                result = Float.parseFloat(operations.get(i-1)) * Float.parseFloat(operations.get(i+1));

            if (Objects.equals(operations.get(i), op.div.function)) { //Division
                if (Float.parseFloat(operations.get(i+1)) == 0) {
                    cleanOperations(); //When division is /0 clean all the operations and throw an exception
                    throw new ArithmeticException("Dividing a number by 0 is not allowed in this program");
                }
                result = Float.parseFloat(operations.get(i-1)) / Float.parseFloat(operations.get(i+1));
            }
            //Saves the result in the place of the second number in the operation
            operations.set(i+1, String.valueOf(result));
        }
        //Restarts the calculator and returns the result
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

        StringBuilder str = new StringBuilder("[STATE:"); //header of the output string
        String str2;

        for (int i = 0; i < operations.size(); i++) {
            //Goes through every element of the list
            str2 = operations.get(i); //Stores the current element in the operation list

            if (i <= 1) { //Exception for the first two elements
                if (isNumeric(str2))
                    str.append("[").append(operations.get(i + 1)).append("]"); //Adds the operation to the string
                else
                    str.append(operations.get(i - 1)).append("_"); //Adds the number
            } else {
                if (isNumeric(str2))
                    str.append(str2); //Adds the number
                else
                    str.append("[").append(str2).append("]"); //Adds the operation
            }
        }
        str.append("]");
        return str.toString();
    }
}