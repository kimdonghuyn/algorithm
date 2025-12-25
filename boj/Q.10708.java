import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[M];
        for (int i = 0; i < M; i++) A[i] = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) B[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] score = new int[N];

        for (int i = 0; i < M; i++) {
            int target = A[i];
            int correct = 0;
            for (int j = 0; j < N; j++) {
                if (B[i][j] == target) {
                    score[j]++;
                    correct++;
                }
            }
            score[target - 1] += (N - correct);
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) sb.append(score[j]).append('\n');
        System.out.print(sb.toString());
    }
}
