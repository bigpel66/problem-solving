package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Data struct {
	value float64
	sb    *StringBuilder
}

type Problem struct {
	*bufio.Reader
	*bufio.Writer
	*Data
}

func newData() *Data {
	return &Data{
		sb: NewStringBuilder(),
	}
}

func newProblem() *Problem {
	return &Problem{
		Reader: bufio.NewReader(os.Stdin),
		Writer: bufio.NewWriter(os.Stdout),
		Data:   newData(),
	}
}

func (p *Problem) input() {
	_, err := fmt.Fscan(p.Reader, &p.value)
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) logic() {
	p.sb.append(fmt.Sprintf("%.2f", p.value/4))
}

func (p *Problem) output() {
	_, err := fmt.Fprint(p.Writer, p.sb.String())
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) solve() {
	p.input()
	p.logic()
	p.output()
}

func main() {
	p := newProblem()
	defer func(p *Problem) {
		_ = p.Flush()
	}(p)
	p.solve()
}

type StringBuilder struct {
	strings.Builder
}

func NewStringBuilder() *StringBuilder {
	var sb StringBuilder
	sb.Grow(30)
	return &sb
}

func (sb *StringBuilder) append(values ...interface{}) {
	for _, value := range values {
		sb.WriteString(convert(value))
	}
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
