class Solution {
    public int maxDistinct(String s) {
        if (s == null || s.isEmpty()) return 0;

        boolean[] seen = new boolean[26];
        int distinct = 0;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (!seen[idx]) {
                seen[idx] = true;
                distinct++;
            }
        }

        return distinct;
    }
}
