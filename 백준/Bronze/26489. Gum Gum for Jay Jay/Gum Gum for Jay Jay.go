package main

import (
	"bufio"
	"fmt"
	"os"
)

type Data struct {
	answer int
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
	for {
		line, err := p.Reader.ReadString('\n')
		if err != nil {
			break
		}
		if line == "gum gum for jay jay\n" {
			p.answer++
		}
	}
}

func (p *Problem) logic() {
}

func (p *Problem) output() {
	_, err := fmt.Fprint(p.Writer, p.answer)
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
