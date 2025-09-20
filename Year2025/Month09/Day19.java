package Year2025.Month09;

public class Day19 {
    public static void main(String[] args) {
        Solution ss = new Solution();
        ss.solution(22, 6, 8);
        ss.solution(13, 6, 4);
//
//        n	    w	num	result
//        22	6	8	3
//        13	3	6	4

    }
}

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int heightMax = (n % w == 0) ? n / w : n / w + 1;
        int[][] storage = new int[heightMax][w];

        int height = 0;
        int arrIdx = 0;
        int arrReverseIdx = w - 1;
        int findHeight = 0;
        int findIdx = 0;
        for (int idx = 0; idx < n; idx++) {
            if (height != idx / w) {
                height++;
                arrIdx = 0;
                arrReverseIdx = w - 1;
            }
            if (height % 2 == 0) {
                storage[height][arrIdx] = idx + 1;
                if (idx + 1 == num) {
                    findHeight = height;
                    findIdx = arrIdx;
                }
                arrIdx++;
            } else {
                storage[height][arrReverseIdx] = idx + 1;
                if (idx + 1 == num) {
                    findHeight = height;
                    findIdx = arrReverseIdx;
                }
                arrReverseIdx--;
            }
        }
        for(int i = findHeight; i <= height; i++) {
            if(storage[i][findIdx] != 0) {
                answer ++;
            }
        }
        return answer;
    }
}