class Solution {
    public String solution(int[] food) {
        StringBuilder left = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int countPerPlayer = food[i] / 2;

            for (int k = 0; k < countPerPlayer; k++) {
                left.append(i);
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append(left);
        answer.append('0');
        answer.append(left.reverse());

        return answer.toString();
    }
}
