package Year2025.Month10;

import java.util.*;

public class Day10 {
    public static void main(String[] args) {
        Solution10 ss = new Solution10();

//        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
//        int m = 3;
//        int k = 5;

        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        int m = 3;
        int k = 5;

        ss.solution(players, m, k);
    }
}

class Solution10 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        LinkedList<ScalingInfo> scalingInfoList = new LinkedList<>();
        for (int i = 0; i < 24; i++) {
            scalingInfoList.add(new ScalingInfo(i, 0)); // 기본값으로 초기화
        }
        for (int i = 0; i < 24; i++) {
            int currentUserCount = players[i];
            int additionalServerCount = 0;
            int expansionCount = 0;
            additionalServerCount = (currentUserCount / m) - scalingInfoList.get(i).addServerCount;

            if (additionalServerCount >= 0) {
                scalingInfoList.get(i).addServerTime = i;
                scalingInfoList.get(i).addServerCount += additionalServerCount;

                for (int j = i + 1; j < i + k && j < 24; j++) {
                    scalingInfoList.get(j).addServerCount += additionalServerCount;
                }
                expansionCount = additionalServerCount;
                answer += expansionCount;
            }
        }
        return answer;
    }
}

class ScalingInfo {
    int addServerTime;
    int addServerCount;

    public ScalingInfo(int time, int addServerCnt) {
        this.addServerTime = time;
        this.addServerCount = addServerCnt;
    }
}