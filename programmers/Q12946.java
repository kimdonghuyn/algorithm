import java.util.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n, 1, 3, 2);
        return list.toArray(new int[1][list.size()]);
    }

    public void hanoi(int n, int from, int to, int mid){
        if(n == 0) return;
        hanoi(n-1, from, mid, to);
        list.add(new int[]{from, to});
        hanoi(n-1, mid, to, from);
    }
}