class Solution {
    public int solution(int storey) {
        int acc = 0;
        while (true) {
            int remain = storey % 10;
            if (remain >= 6) {
                acc += 10 - remain;
                storey += 10 - remain;
            } else if (remain == 5 && (storey / 10 % 10 >= 5)) {
                acc += 5;
                storey += 5;
            } else {
                acc += remain;
            }
            storey /= 10;
            if (storey == 0) {
                break;
            }
        }
        return acc;
    }
}