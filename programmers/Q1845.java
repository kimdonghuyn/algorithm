import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> kinds = new HashSet<>();
        for (int x : nums) {
            kinds.add(x);
        }
        int n = nums.length;
        return Math.min(kinds.size(), n / 2);
    }
}
