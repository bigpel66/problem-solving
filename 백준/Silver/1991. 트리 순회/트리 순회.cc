#include <iostream>
#include <string>
#include <vector>

using namespace std;

class sol {
private:
	int number_of_node;
	vector<vector<int>> tree;

	void stream(void) {
		cin.tie(nullptr);
		ios_base::sync_with_stdio(false);
	}

	void get_input(void) {
		cin >> number_of_node;
		char x, y, z;
		tree = vector<vector<int>>(26);
		for (int i = 0; i < number_of_node; i++) {
			cin >> x >> y >> z;
			if (y == '.') {
				tree[x - 'A'].push_back('0');
			} else {
				tree[x - 'A'].push_back(y - 'A');
			}
			if (z == '.') {
				tree[x - 'A'].push_back('0');
			} else {
				tree[x - 'A'].push_back(z - 'A');
			}
		}
	}

	string preorder(int index) {
		if (index == '0') {
			return "";
		}
		return string(1, index + 'A') + preorder(tree.at(index).at(0)) + preorder(tree.at(index).at(1));
	}

	string inorder(int index) {
		if (index == '0') {
			return "";
		}
		return inorder(tree.at(index).at(0)) + string(1, index + 'A') + inorder(tree.at(index).at(1));
	}

	string postorder(int index) {
		if (index == '0') {
			return "";
		}
		return postorder(tree.at(index).at(0)) + postorder(tree.at(index).at(1)) + string(1, index + 'A');
	}

	void solve(void) {
		cout << preorder(0) << '\n';
		cout << inorder(0) << '\n';
		cout << postorder(0) << '\n';
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