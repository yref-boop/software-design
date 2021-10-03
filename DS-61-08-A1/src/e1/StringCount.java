package e1; //set the package of this class as e1

public class StringCount {

    //attributes
    private String text;
    private int number;

    /**
     * Counts the number of words in a given String.
     * Words are groups of characters separated by one or more spaces.
     *
     * @param text String with the words
     * @return Number of words in the String or zero if it is null
     */

    //methods:
    public static int countWords(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

    /**
     * Counts the number of times the given character appears in the String.
     * Accented characters are considered different characters.
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */

    public static int countChar(String text, char c) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == c)
                count++;
        }
        return count;
    }

    /**
     * Counts the number of times the given character appears in the String.
     * The case is ignored so an ’a’ is equal to an ’A’.
     * Accented characters are considered different characters.
     *
     * @param text String with the characters
     * @param c    the character to be found
     * @return Number of times the character appears in the String or zero if null
     */

    public static int countCharIgnoringCase(String text, char c) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        String text_lc = text.toLowerCase();

        int count = 0;

        for (int i = 0; i < text_lc.length(); i++) {
            if (text_lc.charAt(i) == c)
                count++;
        }
        return count;
    }


    /**
     * Checks if a password is safe according to the following rules:
     * - Has at least 8 characters
     * - Has an uppercase character
     * - Has a lowercase character
     * - Has a digit
     * - Has a special character among these: ’?’, ’@’, ’#’, ’$’, ’.’ and ’,’
     *
     * @param password The password , we assume it is not null.
     * @return true if the password is safe , false otherwise
     */

    public static boolean isPasswordSafe(String password) {

        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        char ch;

        for (int i = 0; i < password.length(); i++) {
            ch = password.charAt(i);
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isDigit(ch)) hasDigit = true;
            hasSpecial = password.matches(".*[?@#$.,].*");
        }

        return (password.length() > 8) && hasUpper && hasLower && hasDigit && hasSpecial;
    }

}