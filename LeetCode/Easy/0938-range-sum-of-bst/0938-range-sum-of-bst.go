// 938. Range Sum of BST
//
// https://leetcode.com/problems/range-sum-of-bst/

/*
** Definition for a binary tree node.
** type TreeNode struct {
**     Val int
**     Left *TreeNode
**     Right *TreeNode
** }
 */

// accumulate Function accumulate the sum of the given range.
// The given range is inclusive.
// [7, 15] means 7<= x <= 15.
func rangeSumBST(root *TreeNode, low int, high int) int {
        sum := 0
        if low <= root.Val && root.Val <= high {
                sum += root.Val
        }
        if root.Left != nil {
                sum += rangeSumBST(root.Left, low, high)
        }
        if root.Right != nil {
                sum += rangeSumBST(root.Right, low, high)
        }
        return sum
}
