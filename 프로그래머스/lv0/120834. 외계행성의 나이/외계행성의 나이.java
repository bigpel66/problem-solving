class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            Character ch = (char)((int)'a' + age % 10);
            sb.append(ch.toString());
            age /= 10;
            if (age == 0) {
                break;
            }
        }
        return sb.reverse().toString();
    }
}