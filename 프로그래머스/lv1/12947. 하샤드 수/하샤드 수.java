class Solution {
    public boolean solution(int x) {
        int sum = Integer.valueOf(x).toString().chars().map(e -> e - '0').sum();
        return x % sum == 0;
    }
}