package Year2025.Month10;

public class Day12 {
    public static void main(String[] args) {
        Solution12 ss = new Solution12();
//
//        storage	requests	result
//        ["AZWQY", "CAABX", "BBDDA", "ACACA"]	["A", "BB", "A"]	11
//        ["HAH", "HBH", "HHH", "HAH", "HBH"]	["C", "B", "B", "B", "B", "H"]	4
        String[] storage = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = {"A", "BB", "A"};
//        String[] storage = {"HAH", "HBH", "HHH", "HAH", "HBH"};
//        String[] requests = {"C", "B", "B", "B", "B", "H"};
        ss.solution(storage, requests);
    }
}

class Solution12 {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        return answer;
    }
}