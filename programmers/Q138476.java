import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int size : tangerine) {
            freq.put(size, freq.getOrDefault(size, 0) + 1);
        }

        ArrayList<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts, Collections.reverseOrder());

        int usedKinds = 0;
        int picked = 0;
        for (int c : counts) {
            picked += c;
            usedKinds++;
            if (picked >= k) break;
        }

        return usedKinds;
    }
}
