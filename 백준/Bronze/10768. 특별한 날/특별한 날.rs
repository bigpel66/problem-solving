use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    month: u32,
    day: u32,
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
        self.reader.read_to_string(&mut input).unwrap();
        let mut input = input
            .split_ascii_whitespace()
            .map(|e| e.parse::<u32>().unwrap());
        let mut input = || input.next().unwrap();
        self.data.month = input();
        self.data.day = input();
    }

    fn solve(&mut self) {
        if (self.data.month < 2) || (self.data.month == 2 && self.data.day < 18) {
            self.answer.push_str("Before");
        } else if (self.data.month > 2) || (self.data.month == 2 && self.data.day > 18) {
            self.answer.push_str("After")
        } else {
            self.answer.push_str("Special")
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data { month: 0, day: 0 }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
