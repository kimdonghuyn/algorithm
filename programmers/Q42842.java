class Solution {
    public int[] solution(int brown, int yellow) {
        int targetSum = (brown - 4) / 2;

        for (int a = 1; a * a <= yellow; a++) {
            if (yellow % a != 0) continue;
            int b = yellow / a;

            if (a + b == targetSum) {
                int width = Math.max(a + 2, b + 2);
                int height = Math.min(a + 2, b + 2);
                return new int[] { width, height };
            }
        }

        return new int[0];

    }
}