class Solution {
    public int solution(int a, int b, int n) {
        // int answer = 0;
        // while (n >= a) {
        //     int quotient = n / a;
        //     n -= quotient * a;
        //     int service = quotient * b;
        //     answer += service;
        //     n += service;
        // }
        // return answer;
        
        // a병 주고 b병 만큼 받으므로 (a - b)병만 있으면 새로운 병을 받을 수 있음
        // 최초엔 (n - b)인 n병에서 b병을 받는 만큼 제해야 a만큼의 차감을 맞출 수 있음
        // (n - b) / (a - b)만큼이 횟수가 되고, 여기서 b병 만큼을 곱하면 총 서비스량
        return (n - b) / (a - b) * b;
    }
    
}
