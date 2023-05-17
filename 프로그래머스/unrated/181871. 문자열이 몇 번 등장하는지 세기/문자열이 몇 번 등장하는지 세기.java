class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0 ; i < myString.length() ; i++) {
            int index = myString.indexOf(pat, i);
            if (index == -1) {
                break;
            }
            i = index;
            answer++;
        }
        return answer;
    }
}