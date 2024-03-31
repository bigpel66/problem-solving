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
	sci []int
	his []int
	sum int
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
	p.logic()
	p.output()
}

func (p *Problem) input() {
	var v int
	for i := 0; i < 4; i++ {
		if _, err := fmt.Fscan(p.Reader, &v); err != nil {
			os.Exit(1)
		}
		p.sci = append(p.sci, v)
		p.sum += v
	}
	for i := 0; i < 2; i++ {
		if _, err := fmt.Fscan(p.Reader, &v); err != nil {
			os.Exit(1)
		}
		p.his = append(p.his, v)
		p.sum += v
	}
}

func (p *Problem) logic() {
	sci := Min(p.sci[0], p.sci[1:]...)
	his := Min(p.his[0], p.his[1:]...)
	p.Append(p.sum - sci - his)
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

func Min[T cmp.Ordered](v1 T, v2 ...T) T {
	for _, v := range v2 {
		if cmp.Compare(v1, v) > 0 {
			v1 = v
		}
	}
	return v1
}

func Max[T cmp.Ordered](v1 T, v2 ...T) T {
	for _, v := range v2 {
		if cmp.Compare(v, v1) > 0 {
			v1 = v
		}
	}
	return v1
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

func (sb *StringBuilder) ReverseAppend(values ...interface{}) *StringBuilder {
	for _, value := range values {
		str := convert(value)
		var res string
		for _, s := range str {
			res = string(s) + res
		}
		sb.WriteString(res)
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
