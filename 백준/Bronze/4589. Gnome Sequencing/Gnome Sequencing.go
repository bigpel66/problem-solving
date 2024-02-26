package main

import (
	"bufio"
	"cmp"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Problem struct {
	*bufio.Reader
	*bufio.Writer
	*StringBuilder
	*Data
}

type Data struct {
	trial int
}

func NewProblem() *Problem {
	return &Problem{
		Reader:        bufio.NewReader(os.Stdin),
		Writer:        bufio.NewWriter(os.Stdout),
		StringBuilder: NewStringBuilder(),
		Data:          NewData(),
	}
}

func NewData() *Data {
	return &Data{}
}

func (p *Problem) Solve() {
	p.input()
	for i := 0; i < p.trial; i++ {
		p.logic()
	}
	p.output()
}

func (p *Problem) input() {
	if _, err := fmt.Fscan(p.Reader, &p.trial); err != nil {
		os.Exit(1)
	}
	p.Append("Gnomes:\n")
}

func (p *Problem) logic() {
	slice := make([]int, 0, 3)
	for i := 0; i < 3; i++ {
		var v int
		if _, err := fmt.Fscan(p.Reader, &v); err != nil {
			os.Exit(1)
		}
		slice = append(slice, v)
	}
	if isNaturalOrder(slice) || isReverseOrder(slice) {
		p.Append("Ordered\n")
	} else {
		p.Append("Unordered\n")
	}
}

func isNaturalOrder(slice []int) bool {
	for i := len(slice) - 1; i > 0; i-- {
		if less(slice[i], slice[i-1]) {
			return false
		}
	}
	return true
}

func isReverseOrder(slice []int) bool {
	for i := len(slice) - 1; i > 0; i-- {
		if greater(slice[i], slice[i-1]) {
			return false
		}
	}
	return true
}

func less(a, b int) bool {
	return cmp.Compare(a, b) < 0
}

func greater(a, b int) bool {
	return cmp.Compare(a, b) > 0
}

func (p *Problem) output() {
	_, err := fmt.Fprint(p.Writer, p.String())
	if err != nil {
		os.Exit(1)
	}
}

func main() {
	p := NewProblem()
	defer func(p *Problem) {
		_ = p.Flush()
	}(p)
	p.Solve()
}

type StringBuilder struct {
	strings.Builder
}

func NewStringBuilder() *StringBuilder {
	var sb StringBuilder
	sb.Grow(30)
	return &sb
}

func (sb *StringBuilder) Append(values ...interface{}) *StringBuilder {
	for _, value := range values {
		sb.WriteString(convert(value))
	}
	return sb
}

func convert(value interface{}) string {
	switch v := value.(type) {
	case string:
		return v
	case int:
		return strconv.Itoa(v)
	case int8:
		return strconv.Itoa(int(v))
	case int16:
		return strconv.Itoa(int(v))
	case int32:
		return strconv.Itoa(int(v))
	case int64:
		return strconv.FormatInt(v, 10)
	case uint:
		return strconv.FormatUint(uint64(v), 10)
	case uint8:
		return strconv.FormatUint(uint64(v), 10)
	case uint16:
		return strconv.FormatUint(uint64(v), 10)
	case uint32:
		return strconv.FormatUint(uint64(v), 10)
	case uint64:
		return strconv.FormatUint(v, 10)
	case float32:
		return strconv.FormatFloat(float64(v), 'f', -1, 32)
	case float64:
		return strconv.FormatFloat(v, 'f', -1, 64)
	default:
		return fmt.Sprintf("%v", v)
	}
}
