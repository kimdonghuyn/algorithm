import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> sorted = new ArrayList<>(sums);
        Collections.sort(sorted);

        int[] answer = new int[sorted.size()];
        for (int i = 0; i < sorted.size(); i++) {
            answer[i] = sorted.get(i);
        }

        return answer;
    }
}
