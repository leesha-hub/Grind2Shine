package Year2025.Month10;

import java.util.*;

public class Day4 {
    public static void main(String[] args) {
        Solution4 ss = new Solution4();

        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 4;
        int m = 4;
//        result : 2

//        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
//        int n = 1;
//        int m = 7;

//        result : 0
//
//        int[][] info = {{3,3}, {3,3}};
//        int n = 7;
//        int m = 1;

//        result : 6
//
//        int[][] info = {{3,3}, {3,3}};
//        int n = 6;
//        int m = 1;

//        result : -1

        ss.solution(info, n, m);
    }
}

class Solution4 {
    int minA = Integer.MAX_VALUE;
    int aLimit, bLimit;

    public int solution(int[][] info, int n, int m) {
        this.aLimit = n - 1;
        this.bLimit = m - 1;
        minA = Integer.MAX_VALUE;

        dfs(info, 0, 0, 0);

        if (minA == Integer.MAX_VALUE) return -1;
        return minA;
    }

    private void dfs(int[][] info, int idx, int sumA, int sumB) {
        // 가지치기
        if (sumA > aLimit || sumB > bLimit) return;

        if (idx == info.length) {
            // a와 b가 모두 한도 내라면 a의 최소값 갱신
            minA = Math.min(minA, sumA);
            return;
        }

        // ① 현재 항목을 b가 훔치는 경우
        dfs(info, idx + 1, sumA, sumB + info[idx][1]);

        // ② 현재 항목을 a가 훔치는 경우
        dfs(info, idx + 1, sumA + info[idx][0], sumB);
    }
}