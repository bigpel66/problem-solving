package main

import (
        "bufio"
        "fmt"
        "os"
)

type data struct {
        r                               *bufio.Reader
        w                               *bufio.Writer
        participants    int
        kim                             int
        lim                             int
        answer                  int
}

func inputAction() *data {
        d := &data{}
        d.r = bufio.NewReader(os.Stdin)
        d.w = bufio.NewWriter(os.Stdout)
        fmt.Fscan(d.r, &d.participants, &d.kim, &d.lim)
        return d
}

func solution(d *data) {
        count := 0
        for {
                count++
                d.kim = (d.kim + 1) / 2
                d.lim = (d.lim + 1) / 2
                if (d.kim == d.lim) {
                        break
                }
        }
        d.answer = count
}

func outputAction(d *data) {
        fmt.Fprint(d.w, d.answer)
}

func main() {
        d := inputAction()
        defer d.w.Flush()
        solution(d)
        outputAction(d)
}
