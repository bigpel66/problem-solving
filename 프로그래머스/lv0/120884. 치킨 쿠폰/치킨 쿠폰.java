class Solution {
    public int solution(int chicken) {
        // int acc = 0;
        // while (true) {
        //     chicken -= 10;
        //     if (chicken >= 0) {
        //         acc++;
        //         chicken++;
        //     } else {
        //         return acc;
        //     }
        // }
        
        int answer = chicken / 9;
        if (chicken > 1 && chicken % 9 == 0) {
            return answer - 1;
        }
        return answer;
    }
}