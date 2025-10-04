package Year2025.Month10;

import java.util.Arrays;
import java.util.Comparator;

public class Day4 {
    public static void main(String[] args) {
        Solution4 ss = new Solution4();

//        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
//        int n = 4;
//        int m = 4;

        int[][] info = {{1, 2}, {2, 3}, {2, 1}};
        int n = 1;
        int m = 7;
//
//        int[][] info = {{3,3}, {3,3}};
//        int n = 7;
//        int m = 1;
//
//        int[][] info = {{3,3}, {3,3}};
//        int n = 6;
//        int m = 1;

        ss.solution(info, n, m);
    }
}

class Solution4 {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;

        // 두 번째 열(index = 1)을 기준으로 정렬
        Arrays.sort(info, Comparator.comparingInt(o -> o[1]));

        int traceAMax = n;
        int traceBMax = m;
        int traceA = 0;
        // 출력 확인
        for (int[] row : info) {
            System.out.println(Arrays.toString(row));
            if (traceBMax - row[1] <= 0) {
                traceA += row[0];
            } else {
                traceBMax -= row[1];
            }
        }
        if(traceA > 0 && traceA < traceAMax) {
            answer = traceA;
        } else if(traceA == 0) {
            answer = traceA;
        } else {
            answer = -1;
        }
        return answer;
    }
}