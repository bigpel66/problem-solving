package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var classMap = map[string]string{
	"Algorithm":              "204",
	"DataAnalysis":           "207",
	"ArtificialIntelligence": "302",
	"CyberSecurity":          "B101",
	"Network":                "303",
	"Startup":                "501",
	"TestStrategy":           "105",
}

type Problem struct {
	*bufio.Reader
	*bufio.Writer
	*StringBuilder
	*Data
}

type Data struct {
	classes []string
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
	var trial int
	if _, err := fmt.Fscan(p.Reader, &trial); err != nil {
		os.Exit(1)
	}
	var class string
	for i := 0; i < trial; i++ {
		if _, err := fmt.Fscan(p.Reader, &class); err != nil {
			os.Exit(1)
		}
		p.classes = append(p.classes, class)
	}
}

func (p *Problem) logic() {
	for _, c := range p.classes {
		p.Append(classMap[c]).Append("\n")
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
