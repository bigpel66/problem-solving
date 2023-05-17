#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> numbers) {
    stack<int> st;
    vector<int> answer(numbers.size(), -1);
    for (int i = 0 ; i < numbers.size() ; i++) {
        while (!st.empty() && numbers.at(st.top()) < numbers.at(i)) {
            answer[st.top()] = numbers.at(i);
            st.pop();
        }
        st.push(i);
    }
    return answer;
}