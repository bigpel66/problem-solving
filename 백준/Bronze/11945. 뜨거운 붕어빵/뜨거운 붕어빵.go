package main

import (
	"bufio"
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
	row  int
	col  int
	fish []string
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
	if _, err := fmt.Fscan(p.Reader, &p.row, &p.col); err != nil {
		os.Exit(1)
	}
	if p.row == 0 || p.col == 0 {
		os.Exit(0)
	}
	for i := 0; i < p.row; i++ {
		var fish string
		if _, err := fmt.Fscan(p.Reader, &fish); err != nil {
			os.Exit(1)
		}
		p.fish = append(p.fish, fish)
	}
}

func (p *Problem) logic() {
	for _, f := range p.fish {
		p.ReverseAppend(f).Append("\n")
	}
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
