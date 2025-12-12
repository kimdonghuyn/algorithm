class Solution {
    public int solution(int n) {
        int targetCount = Integer.bitCount(n);

        int nextNumber = n + 1;
        while (Integer.bitCount(nextNumber) != targetCount) {
            nextNumber++;
        }

        return nextNumber;
    }
}