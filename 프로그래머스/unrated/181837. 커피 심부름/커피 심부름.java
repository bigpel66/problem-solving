class Solution {
    public int solution(String[] order) {
        int acc = 0;
        for (int i = 0 ; i < order.length ; i++) {
            if (order[i].contains("americano")) {
                acc += 4500;
            } else if (order[i].contains("cafelatte")) {
                acc += 5000;
            } else {
                acc += 4500;
            }
        }
        return acc;
    }
}