class Solution {
    public int solution(int num, int k) {
        int index = -1;
        int length = 0;
        while (true) {
            int val = num % 10;
            if (val == k) {
                index = length;
            }
            num /= 10;
            length++;
            if (num == 0) {
                return index == -1 ? -1 : length - index;
            }
        }
    }
}