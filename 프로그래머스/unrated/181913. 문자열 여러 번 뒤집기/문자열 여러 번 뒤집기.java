class Solution {
    public String solution(String my_string, int[][] queries) {
        for (int i = 0 ; i < queries.length ; i++) {
            StringBuilder sb = new StringBuilder(my_string.substring(0, queries[i][0]));
            StringBuilder ot = new StringBuilder(my_string.substring(queries[i][0], queries[i][1] + 1));
            sb.append(ot.reverse().toString()).append(my_string.substring(queries[i][1] + 1));
            my_string = sb.toString();
        }
        return my_string;
    }
}