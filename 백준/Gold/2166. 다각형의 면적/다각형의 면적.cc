#include <cmath>
#include <iostream>
#include <utility>
#include <vector>

using namespace std;
using point = pair<long long, long long>;

class sol {
private:
	int number_of_point;
	double area;
	vector<point> v;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_point;
		area = 0.0;
		v = vector<point>(number_of_point);
		for (int i = 0; i < number_of_point; i++) {
			cin >> v[i].first >> v[i].second;
		}
	}

	double ccw(const point& p1, const point& p2, const point& p3) {
		double product = p1.first * p2.second + p2.first * p3.second + p3.first * p1.second
			- p2.first * p1.second - p3.first * p2.second - p1.first * p3.second;
		return product / 2;
	}

	void solve(void) {
		for (int i = 1; i < number_of_point - 1; i++) {
			area += ccw(v.at(0), v.at(i), v.at(i + 1));
		}
		area = abs(area);
		cout << fixed;
		cout.precision(1);
		cout << area;
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