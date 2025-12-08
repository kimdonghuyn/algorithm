import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boatCount = 0;
        int lightIndex = 0;
        int heavyIndex = people.length - 1;

        Arrays.sort(people);

        while (lightIndex <= heavyIndex) {
            if (people[lightIndex] + people[heavyIndex] <= limit) lightIndex++;

            heavyIndex--;
            boatCount++;
        }

        return boatCount;
    }
}