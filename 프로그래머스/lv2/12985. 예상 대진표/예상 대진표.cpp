#include <cmath>

using namespace std;

int solution(int n, int a, int b) {
    int answer = 0;
    while (true) {
        if (a == b) {
            break;
        }
        a = (int) ceil((double) a / 2);
        b = (int) ceil((double) b / 2);
        answer++;
    }
    return answer;
}