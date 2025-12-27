import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> seen = new HashSet<>();
        char prevLast = 0;

        for (int i = 0; i < words.length; i++) {
            String w = words[i];

            boolean invalid =
                    (i > 0 && w.charAt(0) != prevLast) ||
                            seen.contains(w) ||
                            w.length() < 2;

            if (invalid) {
                int player = (i % n) + 1;
                int turn = (i / n) + 1;
                return new int[] { player, turn };
            }

            seen.add(w);
            prevLast = w.charAt(w.length() - 1);
        }

        return new int[] { 0, 0 };
    }
}
