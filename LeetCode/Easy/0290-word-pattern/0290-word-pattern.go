// 290. Word Pattern
//
// https://leetcode.com/problems/word-pattern/

import (
	"strings"
)

func wordPattern(pattern string, s string) bool {
	matching := make(map[byte]string)
	wordMap := make(map[string]byte)
	words := strings.Split(s, " ")
	if len(pattern) != len(words) {
		return false
	}
	for i := 0; i < len(pattern); i++ {
		ch, word := pattern[i], words[i]
		if val, ok := matching[ch]; ok {
			if val != word {
				return false
			}
		} else {
			matching[ch] = word
		}
		if val, ok := wordMap[word]; ok {
			if val != ch {
				return false
			}
		} else {
			wordMap[word] = ch
		}
	}
	return true
}