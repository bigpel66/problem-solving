package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

type Data struct {
	trial int
	sb    strings.Builder
}

type Problem struct {
	*bufio.Reader
	*bufio.Writer
	*Data
}

func newProblem() *Problem {
	return &Problem{
		Reader: bufio.NewReader(os.Stdin),
		Writer: bufio.NewWriter(os.Stdout),
		Data:   new(Data),
	}
}

func (p *Problem) input() {
	_, err := fmt.Fscan(p.Reader, &p.trial)
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) logic() {
	var value string
	_, err := fmt.Fscan(p.Reader, &value)
	if err != nil {
		os.Exit(1)
	}
	p.sb.WriteString(value + " " + value + "\n")
}

func (p *Problem) output() {
	_, err := fmt.Fprint(p.Writer, p.sb.String())
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) solve() {
	p.input()
	for i := 0; i < p.trial; i++ {
		p.logic()
	}
	p.output()
}

func main() {
	p := newProblem()
	defer func(p *Problem) {
		_ = p.Flush()
	}(p)
	p.solve()
}
