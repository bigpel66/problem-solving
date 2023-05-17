#include <cmath>
#include <string>
#include <vector>

using namespace std;

vector<double> get_collatz(int k) {
    vector<double> vec;
    while (k != 1) {
        vec.push_back(k);
        if (k % 2 == 0) {
            k /= 2;
        } else {
            k = k * 3 + 1;
        }
    }
    vec.push_back(1);
    return vec;
}

vector<double> get_area(vector<double>& collatz) {
    vector<double> vec;
    for (int i = 0 ; i < collatz.size() - 1 ; i++) {
        double val = max(collatz.at(i), collatz.at(i + 1));
        vec.push_back(val - abs(collatz.at(i) - collatz.at(i + 1)) / 2);
    }
    return vec;
}

vector<double> get_cumsum(vector<double>& area) {
    vector<double> vec;
    vec.push_back(0);
    for (int i = 0 ; i < area.size() ; i++) {
        if (i == 0) {
            vec.push_back(area.at(i));
        } else {
            vec.push_back(vec.at(i) + area.at(i));
        }
    }
    return vec;
}

vector<double> get_ranged_areas(vector<double>& cumsum, vector<vector<int>>& ranges) {
    vector<double> vec;
    for (auto&& i : ranges) {
        int begin = i.at(0);
        int end = cumsum.size() + i.at(1) - 1;
        if (begin <= end) {
            vec.push_back(cumsum.at(end) - cumsum.at(begin));
        } else {
            vec.push_back(-1.0);
        }
    }
    return vec;
}

vector<double> solution(int k, vector<vector<int>> ranges) {
    auto&& collatz = get_collatz(k);
    auto&& area = get_area(collatz);
    auto&& cumsum = get_cumsum(area);
    return get_ranged_areas(cumsum, ranges);
}