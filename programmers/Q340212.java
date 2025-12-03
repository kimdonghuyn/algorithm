import java.util.*;

public class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int lo = 1, hi = 1;
        for (int d : diffs) hi = Math.max(hi, d);

        int ans = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(diffs, times, mid, limit)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private boolean canFinish(int[] diffs, int[] times, int level, long limit) {
        long remain = limit;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                remain -= times[i];
            } else {
                long wrong = (long) diffs[i] - level;
                long timePrev = (i == 0) ? 0L : (long) times[i - 1];
                long cost = wrong * ((long) times[i] + timePrev) + times[i];
                remain -= cost;
            }
            if (remain < 0) return false;
        }
        return true;
    }
}
