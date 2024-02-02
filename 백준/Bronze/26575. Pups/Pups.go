package main

import (
	"bufio"
	"fmt"
	"math/big"
	"os"
)

type Data struct {
	dog    big.Float
	food   big.Float
	price  big.Float
	answer *big.Float
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
	_, err := fmt.Fscan(p.Reader, &p.dog, &p.food, &p.price)
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) logic() {
	mul := big.NewFloat(1).Mul(&p.dog, &p.food)
	p.answer = mul.Mul(mul, &p.price)
}

func (p *Problem) output() {
	_, err := fmt.Fprint(p.Writer, fmt.Sprintf("$%.2f\n", p.answer))
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
	var trial int
	_, err := fmt.Fscan(p.Reader, &trial)
	if err != nil {
		os.Exit(1)
	}
	for i := 0; i < trial; i++ {
		p.solve()
	}
}
