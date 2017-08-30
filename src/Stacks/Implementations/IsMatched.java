package Stacks.Implementations;

import java.util.Stack;

public class IsMatched {
    private static final String opening = "({["; // opening delimiters
    private static final String closing = "]})"; // respective closing delimiters

    private static Stack<Character> buffer = new Stack<>();

    public static boolean isMatched(String expression) {
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) { // this is left delimiter
                buffer.push(c);
            }else if (closing.indexOf(c) != -1) { // this is right delimiter
                if (buffer.isEmpty()) { // nothing to match
                    return false;
                }
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) {
                    return false; // mismatched delimiter
                }
            }
        }
        return buffer.isEmpty(); // were all opening delimiters matched?
    }
}
