#include <algorithm>
#include <iostream>
#include <stack>
#include <string>
#include <unordered_set>
#include <utility>
#include <vector>

using namespace std;
using parenthesis = pair<int, int>;

class sol {
private:
    string original;
    stack<int> st;
    unordered_set<int> skip;
    vector<parenthesis> p;
    vector<bool> is_visited;
    vector<string> answer;

    void stream(void) {
        cin.tie(nullptr);
        ios_base::sync_with_stdio(false);
    }

    void get_input(void) {
        cin >> original;
        for (size_t i = 0 ; i < original.length() ; i++) {
            if (original.at(i) == '(') {
                st.push(i);
            } else if (original.at(i) == ')') {
                p.push_back({st.top(), i});
                st.pop();
            }
        }
    }

    void mask_bitset(int bitset) {
        int i = 0;
        while (bitset) {
            if (bitset & 1) {
                is_visited[i] = true;
            }
            bitset >>= 1;
            i++;
        }
    }

    void find_skip(void) {
        for (size_t i = 0 ; i < is_visited.size() ; i++) {
            if (is_visited.at(i)) {
                skip.insert({p.at(i).first, p.at(i).second});
            }
        }
    }

    void find_expression(void) {
        string temp;
        for (size_t i = 0 ; i < original.length() ; i++) {
            if (skip.count(i)) {
                continue;
            }
            temp.push_back(original.at(i));
        }
        if (original != temp) {
            answer.push_back(temp);
        }

    }

    void solve(void) {
        for (int i = 0 ; i < (1 << p.size()) ; i++) {
            skip.clear();
            is_visited = vector<bool>(p.size(), false);
            mask_bitset(i);
            find_skip();
            find_expression();
        }
        sort(answer.begin(), answer.end(), less<string>());
        answer.erase(unique(answer.begin(), answer.end()), answer.end());
        for (auto&& i : answer) {
            cout << i << '\n';
        }
    }

public:
    sol(void) {
        stream();
        get_input();
        solve();
    }
};

int main(void) {
    sol ve;
    return 0;
}