import java.util.*;

class Solution {
    public int[] solution(String s) {
        int n = s.length();
        int[] answer = new int[n];

        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if(lastIndex[idx] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - lastIndex[idx];
            }

            lastIndex[idx] = i;
        }

        return answer;
    }
}