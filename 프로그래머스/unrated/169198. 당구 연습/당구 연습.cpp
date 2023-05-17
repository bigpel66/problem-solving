#include <climits>
#include <cmath>
#include <vector>

using namespace std;
using point = pair<int, int>;

int get_pow_distance(point& p1, point& p2) {
    return pow(p1.first - p2.first, 2) + pow(p1.second - p2.second, 2);
}

vector<point> get_symmetric_points(point& border, point& start, point&& ball) {
    vector<point> vec;
    if (!(start.first == ball.first && start.second < ball.second)) {
        vec.push_back({ball.first, border.second + (border.second - ball.second)});    
    }
    if (!(start.first == ball.first && start.second > ball.second)) {
        vec.push_back({ball.first, ball.second * -1});    
    }
    if (!(start.first < ball.first && start.second == ball.second)) {
        vec.push_back({border.first + (border.first - ball.first), ball.second});    
    }
    if (!(start.first > ball.first && start.second == ball.second)) {
        vec.push_back({ball.first * -1, ball.second});    
    }
    return vec;
}

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    point border(m ,n);
    point start(startX, startY);
    for (auto&& ball : balls) {
        vector<point>&& symmetrics = get_symmetric_points(border, start, point(ball.at(0), ball.at(1)));
        int dist = INT_MAX;
        for (auto&& i : symmetrics) {
            dist = min(dist, get_pow_distance(start, i));
        }
        answer.push_back(dist);
    }
    return answer;
}