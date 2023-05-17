class Solution {
    public String solution(String rsp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < rsp.length() ; i++) {
            Character ch = rsp.charAt(i);
            sb.append(counterString(ch.toString()));
        }
        return sb.toString();
    }
    
    public String counterString(String s) {
        if (s.equals("2")) {
            return "0";
        } else if (s.equals("0")) {
            return "5";
        } else {
            return "2";
        }
    }
}