#include <algorithm>
#include <cmath>
#include <string>
#include <regex>
#include <unordered_map>
#include <vector>

using namespace std;

const string preset("+-*");

vector<string> re_split(string s, const regex& r) {
    vector<string> vec;
    regex_token_iterator<string::iterator> iter(s.begin(), s.end(), r, -1);
    regex_token_iterator<string::iterator> end;
    while (iter != end) {
        vec.push_back(*iter++);
    }
    return vec;
}

vector<long long> wrap_to_long_long(vector<string>&& vec) {
    vector<long long> wrap;
    for (auto&& i : vec) {
        wrap.push_back(stoll(i));
    }
    return wrap;
}

long long operate(char op, long long v1, long long v2) {
    if (op == '+') {
        return v1 + v2;
    } else if (op == '-') {
        return v1 - v2;
    } else {
        return v1 * v2;
    }
}

long long expression_result(const vector<int>& order, vector<long long> operands, vector<string> operators) {
    for (auto&& i : order) {
        while (true) {
            bool is_deleted = false;
            for (auto&& j = operators.begin() ; j != operators.end() ; j++) {
                if (j->at(0) != preset.at(i)) {
                    continue;
                }
                int index = j - operators.begin();
                long long calc = operate(preset.at(i), operands.at(index), operands.at(index + 1));
                operands.erase(operands.begin() + index + 1);
                operands.erase(operands.begin() + index);
                operands.insert(operands.begin() + index, calc);
                operators.erase(j);
                is_deleted = true;
                break;
            }
            if (!is_deleted) {
                break;
            }
        }
    }
    return operands.at(0);
}

void dfs(long long& answer, vector<int>& order,  vector<bool>& is_visited, vector<long long>& operands, vector<string>& operators) {
    if (order.size() == 3) {
        answer = max(answer, abs(expression_result(order, operands, operators)));
        return;
    }
    for (int i = 0 ; i < 3 ; i++) {
        if (is_visited[i]) {
            continue;
        }
        is_visited[i] = true;
        order.push_back(i);
        dfs(answer, order, is_visited, operands, operators);
        order.pop_back();
        is_visited[i] = false;
    }
}

long long solution(string expression) {
    long long answer = 0;
    vector<int> order;
    vector<bool> is_visited(3, false);
    vector<long long>&& operands = wrap_to_long_long(re_split(expression, regex(R"(\+|\-|\*)")));
    vector<string>&& operators = re_split(expression, regex(R"([\d]+)"));
    operators.erase(remove(operators.begin(), operators.end(), ""), operators.end());  
    dfs(answer, order, is_visited, operands, operators);
    return answer;
}