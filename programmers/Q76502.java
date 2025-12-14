import java.util.Stack;

class Solution {
    public int solution(String s) {
        int n = s.length();
        if (n == 0) return 0;
        if ((n & 1) == 1) return 0;

        int count = 0;
        for (int shift = 0; shift < n; shift++) {
            if (isValidRotation(s, shift)) count++;
        }
        return count;
    }

    private boolean isValidRotation(String s, int shift) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt((i + shift) % n);
            switch (c) {
                case '(': case '[': case '{':
                    stack.push(c);
                    break;
                case ')': case ']': case '}':
                    if (stack.isEmpty()) return false;
                    char open = stack.pop();
                    if (!matches(open, c)) return false;
                    break;
                default:
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '[' && close == ']')
                || (open == '{' && close == '}');
    }
}
