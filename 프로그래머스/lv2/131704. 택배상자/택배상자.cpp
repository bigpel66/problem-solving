#include <stack>
#include <vector>

using namespace std;

int solution(vector<int> order) {
    int answer = 0;
    stack<int> st;
    for (int i = 1 ; i <= order.size() ; i++) {
        st.push(i);
        while (!st.empty() && st.top() == order.at(answer)) {
            answer++;
            st.pop();
        }
    }
    return answer;
}

