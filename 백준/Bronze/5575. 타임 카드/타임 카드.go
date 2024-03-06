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
	a Pair
	b Pair
	c Pair
}

type Pair struct {
	begin    Work
	end      Work
	duration int
}

type Work struct {
	hour   int
	minute int
	second int
	stamp  int
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
	p.a.input(p)
	p.b.input(p)
	p.c.input(p)
}

func (p *Pair) input(problem *Problem) {
	p.begin.input(problem)
	p.end.input(problem)
	p.duration = p.end.stamp - p.begin.stamp
}

func (w *Work) input(problem *Problem) {
	if _, err := fmt.Fscan(problem.Reader, &w.hour, &w.minute, &w.second); err != nil {
		os.Exit(1)
	}
	w.stamp = w.hour*60*60 + w.minute*60 + w.second
}

func (p *Problem) logic() {
	p.formatAppend(durationToTime(p.a.duration))
	p.formatAppend(durationToTime(p.b.duration))
	p.formatAppend(durationToTime(p.c.duration))
}

func (p *Problem) formatAppend(hour, minute, second int) {
	p.Append(hour).Append(" ").Append(minute).Append(" ").Append(second).Append("\n")
}

func durationToTime(duration int) (int, int, int) {
	second := duration % 60
	minute := duration / 60
	hour := minute / 60
	minute %= 60
	return hour, minute, second
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
