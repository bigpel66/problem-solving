#include <iostream>
#include <string>

using namespace std;

class sol {
private:
	string s;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		s = R"(.  .   .
|  | _ | _. _ ._ _  _
|/\|(/.|(_.(_)[ | )(/.)";
	}

	void solve(void) {
		cout << s;
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