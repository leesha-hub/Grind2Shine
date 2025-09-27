package Year2025.Month09;

public class Day25 {
    public static void main(String[] args) {
        Solution25 ss = new Solution25();

//        int[] schedules = {700, 800, 1100};
//        int[][] timelogs = {
//                            {710, 2359, 1050, 700, 650, 631, 659},
//                            {800, 801, 805, 800, 759, 810, 809},
//                            {1105, 1001, 1002, 600, 1059, 1001, 1100}
//                           };
//        int startday = 5;

        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday = 1;

        ss.solution(schedules, timelogs, startday);
    }
}

class Solution25 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        int origStartDday = startday;
        int startDay = origStartDday;

        int cnt = 0; // 월,화,수,목,금 정상 출근시 ++ 토,일 제외
        int dayCheck = 0; // 7일 모두 체크했는지 카운트
        int peopleNum = timelogs.length - 1;
        for (int i = 0; i <= peopleNum; i++) {
            // 초기화
            cnt = 0;
            startDay = origStartDday;
            dayCheck = 0;
            for (int j = 0; j < 7; j++) {
                if (startDay <= 5) {
                    if (timelogs[i][j] - schedules[i] <= 10) {
                        cnt++;
                    }
                }
                dayCheck++;
                startDay++;
                // 아직 7일 모두 체크하지 않았는데 startDay가 일요일일때 월요일로 세팅
                if (dayCheck < 7 && startDay == 8) {
                    startDay = 1;
                }
            }
            if (cnt == 5) {
                answer++;
            }
        }
        return answer;
    }
}