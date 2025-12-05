import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0;
        long currentSum = 0;
        int bestStart = 0;
        int bestEnd = n - 1;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentSum += sequence[right];

            while (left <= right && currentSum > k) {
                currentSum -= sequence[left];
                left++;
            }

            if (currentSum == k) {
                int len = right - left + 1;
                if (len < bestLen || (len == bestLen && left < bestStart)) {
                    bestLen = len;
                    bestStart = left;
                    bestEnd = right;
                }
                currentSum -= sequence[left];
                left++;
            }
        }

        return new int[] { bestStart, bestEnd };
    }
}
