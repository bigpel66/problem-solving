use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Vec<i32>,
    apple: (i32, i32, i32),
    answer: String,
}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            data: Vec::new(),
            apple: (0, 0, 0),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        let mut input = String::new();
        self.reader.read_to_string(&mut input).unwrap();
        let mut input = input
            .split_ascii_whitespace()
            .map(|e| e.parse::<i32>().unwrap());
        let mut input = || input.next().unwrap();
        for _i in 0..4 {
            self.data.push(input());
        }
        self.apple = (input(), input(), input());
    }

    fn solve(&mut self) {
        for i in 0..4 {
            if self.data[i] == self.apple.0 {
                self.answer.push_str(&(i + 1).to_string());
                return;
            }
        }
        self.answer.push_str("0");
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
