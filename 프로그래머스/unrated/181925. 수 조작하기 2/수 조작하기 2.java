class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < numLog.length - 1 ; i++) {
            int diff = numLog[i + 1] - numLog[i];
            if (diff == 1) {
                sb.append('w');
            } else if (diff == -1) {
                sb.append('s');
            } else if (diff == 10) {
                sb.append('d');
            } else {
                sb.append('a');
            }
        }
        return sb.toString();
    }
}