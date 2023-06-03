#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_sequence, target_sum;
	int begin, end;
	vector<int> sequence;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_sequence >> target_sum;
		sequence = vector<int>(number_of_sequence);
		for (int i = 0; i < number_of_sequence; i++) {
			cin >> sequence[i];
		}
		begin = 0;
		end = 0;
	}

	void solve(void) {
		int min_length = INT_MAX;
		int sum = 0;
		while (begin <= end) {
			if (target_sum <= sum) {
				min_length = min(min_length, end - begin);
				sum -= sequence.at(begin++);
			} else if (end == number_of_sequence) {
				break;
			} else  {
				sum += sequence.at(end++);
			}
		}
		cout << (min_length == INT_MAX ? 0 : min_length);
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