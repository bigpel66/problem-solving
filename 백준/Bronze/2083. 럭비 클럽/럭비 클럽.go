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
	members []Member
}

type Member struct {
	name   string
	age    int
	weight int
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
	return &Data{
		members: make([]Member, 0, 10),
	}
}

func (p *Problem) Solve() {
	p.input()
	p.logic()
	p.output()
}

func (p *Problem) input() {
	for member := new(Member); member.input(p); member = new(Member) {
		p.members = append(p.members, *member)
	}
}

func (m *Member) input(p *Problem) bool {
	if _, err := fmt.Fscan(p.Reader, &m.name, &m.age, &m.weight); err != nil {
		os.Exit(1)
	}
	return !(m.name == "#" && m.age == 0 && m.weight == 0)
}

func (p *Problem) logic() {
	for _, m := range p.members {
		if m.age > 17 || m.weight >= 80 {
			p.Append(m.name).Append(" ").Append("Senior")
		} else {
			p.Append(m.name).Append(" ").Append("Junior")
		}
		p.Append("\n")
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
