package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

const preset = ` @@@   @@@ 
@   @ @   @
@    @    @
@         @
 @       @ 
  @     @  
   @   @   
    @ @    
     @     `

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
	_, err := fmt.Fscanf(p.Reader, "%d\n", &p.trial)
	if err != nil {
		os.Exit(1)
	}
}

func (p *Problem) logic() {
	for i := 0; i < p.trial; i++ {
		p.sb.WriteString(preset)
		p.sb.WriteString("\n")
	}
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
