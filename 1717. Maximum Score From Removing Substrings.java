import java.util.*;

public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) return calculateScore(s, "ab", x, "ba", y);
        else return calculateScore(s, "ba", y, "ab", x);
    }

    private int calculateScore(String s, String first, int firstScore, String second, int secondScore) {
        Stack<Character> stack = new Stack<>();
        int score = 0;
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == first.charAt(0) && c == first.charAt(1)) {
                stack.pop();
                score += firstScore;
            } else {
                stack.push(c);
            }
        }
        Stack<Character> temp = new Stack<>();
        while (!stack.isEmpty()) temp.push(stack.pop());
        while (!temp.isEmpty()) {
            char c = temp.pop();
            if (!stack.isEmpty() && stack.peek() == second.charAt(0) && c == second.charAt(1)) {
                stack.pop();
                score += secondScore;
            } else {
                stack.push(c);
            }
        }
        return score;
    }
}
