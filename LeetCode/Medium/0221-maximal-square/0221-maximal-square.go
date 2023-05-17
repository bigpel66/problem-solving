// 221. Maximal Square
//
// https://leetcode.com/problems/maximal-square/description/

// min Function get the value which is smaller than another.
func min(a, b int) int {
        if a < b {
                return a
        }
        return b
}

// max Function get the value which is bigger than another.
func max(a, b int) int {
        if a > b {
                return a
        }
        return b
}

// maximalSquare Function finds the largest square from the given matrix
func maximalSquare(matrix [][]byte) int {
        ans := 0
        row, col := len(matrix), len(matrix[0])
        tile := make([][]int, row+1)
        for i := 0; i < row+1; i++ {
                tile[i] = make([]int, col+1)
        }
        for i := 1; i < row+1; i++ {
                for j := 1; j < col+1; j++ {
                        tile[i][j] = int(matrix[i-1][j-1] - '0')
                        if tile[i][j] == 1 {
                                tile[i][j] = min(tile[i-1][j-1], min(tile[i-1][j], tile[i][j-1])) + 1
                        }
                        ans = max(ans, tile[i][j])
                }
        }
        return ans * ans
}
