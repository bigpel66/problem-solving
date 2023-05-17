class Solution {
private:
	vector<int> _val;
	int _valSize;
    long long seed;

public:
    double randv(void) {
        seed = (seed * 1103515245 + 12345) & 0x7fffffff;
        return static_cast<double>(seed) / static_cast<double>(0x80000000);
    }

    double randr(double min, double max) {
        return (randv() * (max - min)) + min;
    }

	Solution(ListNode *head) {
        seed = 0 ;
		_valSize = 0;
		while (head) {
			_val.push_back(head->val);
			head = head->next;
			_valSize++;
		}
	}
	int getRandom() {
		return _val[randr(0, _valSize)];
	}
};