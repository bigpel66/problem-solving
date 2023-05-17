class Solution {
    public int solution(String myString, String pat) {
        myString = myString.replaceAll("A", "T");
        myString = myString.replaceAll("B", "A");
        myString = myString.replaceAll("T", "B");
        return myString.contains(pat) ? 1 : 0;
    }
}