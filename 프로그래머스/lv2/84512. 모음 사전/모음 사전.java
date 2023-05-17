class Solution {
    public int solution(String word) {
        String order = "AEIOU";
        int[] value = new int[]{781, 156, 31, 6, 1};
        int acc = 0;
        for (int i = 0; i < word.length(); i++) {
            acc += order.indexOf(word.charAt(i)) * value[i];
        }
        return word.length() + acc;
    }
}