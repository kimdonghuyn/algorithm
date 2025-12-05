import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idx.put(friends[i], i);
        }

        int[][] sent = new int[n][n];
        int[] totalSent = new int[n];
        int[] totalReceived = new int[n];

        for (String g : gifts) {
            String[] parts = g.split(" ");
            String A = parts[0];
            String B = parts[1];
            int i = idx.get(A);
            int j = idx.get(B);

            sent[i][j]++;
            totalSent[i]++;
            totalReceived[j]++;
        }

        int[] giftIndex = new int[n];
        for (int i = 0; i < n; i++) {
            giftIndex[i] = totalSent[i] - totalReceived[i];
        }

        int[] nextReceived = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ij = sent[i][j];
                int ji = sent[j][i];

                if (ij > ji) {
                    nextReceived[i]++;
                } else if (ij < ji) {
                    nextReceived[j]++;
                } else {
                    if (giftIndex[i] > giftIndex[j]) {
                        nextReceived[i]++;
                    } else if (giftIndex[i] < giftIndex[j]) {
                        nextReceived[j]++;
                    }
                }
            }
        }

        int ans = 0;
        for (int x : nextReceived) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}
