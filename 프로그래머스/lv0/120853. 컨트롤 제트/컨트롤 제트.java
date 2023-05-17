class Solution {
    public int solution(String s) {
        String[] split = s.split(" ");
        Integer acc = 0;
        Integer pre = 0;
        for (int i = 0 ; i < split.length ; i++) {
            try {
                pre = Integer.parseInt(split[i]);
                acc += pre;
            } catch (Exception e) {
                acc -= pre;
            }
        }
        return acc;
    }
}