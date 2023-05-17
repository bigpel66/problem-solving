// 1217. Minimum Cost to Move Chips to The Same Position
//
// https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
//
//	Moving 2 steps == 0 cost
//	Moving 1 step == 1 cost
//	+, - direction possible
//	What is the minimum cost?
func minCostToMoveChips(position []int) int {
	var cnt int
	for _, number := range position {
		if number%2 == 1 {
			cnt++
		}
	}
	if cnt > len(position)-cnt {
		return len(position) - cnt
	} else {
		return cnt
	}
}