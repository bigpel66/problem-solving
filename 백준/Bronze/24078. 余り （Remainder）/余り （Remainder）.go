package main

import (
	"bufio"
	"fmt"
	"os"
)

type Data struct {
	number int
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
	_, err := fmt.Fscan(
		p.Reader,
		&p.number,
	)
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) logic() {
	p.answer = p.number % 21
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
