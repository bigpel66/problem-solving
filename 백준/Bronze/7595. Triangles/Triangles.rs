use std::io;
use std::io::{BufRead, BufReader, BufWriter, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    height: u32,
}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            data: Data::new(),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        let mut input = String::new();
        self.reader.read_line(&mut input).unwrap();
        let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
        let mut input = || input.next().unwrap();
        self.data.height = input();
    }

    fn solve(&mut self) {
        for i in 1..self.data.height + 1 {
            for _j in 1..i + 1 {
                self.answer.push('*');
            }
            self.answer.push('\n');
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            height: 0,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    loop {
        problem.input();
        if problem.data.height == 0 {
            break;
        }
        problem.solve();
    }
    problem.output();
}