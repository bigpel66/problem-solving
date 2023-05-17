// 231. Power of Two
//
// https://leetcode.com/problems/power-of-two/

func isPowerOfTwo(n int) bool {
	cnt := 0
	for i := 0; i < 64; i++ {
		if n&1 == 1 {
			cnt++
		}
		n = n >> 1
	}
	return cnt == 1
}