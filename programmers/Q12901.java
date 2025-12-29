class Solution {
    public String solution(int a, int b) {
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int offset = 5;

        int days = b - 1;
        for (int i = 0; i < a - 1; i++) {
            days += monthDays[i];
        }

        return week[(offset + days) % 7];
    }
}
