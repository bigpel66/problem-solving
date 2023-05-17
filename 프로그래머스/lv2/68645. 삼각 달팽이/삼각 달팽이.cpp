#include <algorithm>
#include <vector>

using namespace std;

vector<int> solution(int n) {
    vector<int> answer(n * n);
    int row = -1;
    int col = 0;
    int count = 1; 
    for (int size = n ; size > 0 ; size -= 3) {
        for (int i = 0 ; i < size ; i++) {
            answer[++row * n + col] = count++;
        }
        for (int i = 0 ; i < size - 1 ; i++) {
            answer[row * n + ++col] = count++;
        }
        for (int i = 0 ; i < size - 2 ; i++) {
            answer[--row * n + --col] = count++;
        }
    }
    answer.erase(remove(answer.begin(), answer.end(), 0), answer.end());
    return answer;
}