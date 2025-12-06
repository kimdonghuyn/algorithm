import java.util.*;

class Solution {
    public int[] solution(int[] NVIDIA) {
        int n = NVIDIA.length;
        int[] answer = new int[n];

        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!indexStack.isEmpty() && NVIDIA[i] < NVIDIA[indexStack.peek()]) {
                int j = indexStack.pop();
                answer[j] = i - j;
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            int j = indexStack.pop();
            answer[j] = n - j - 1;
        }

        return answer;
    }
}
