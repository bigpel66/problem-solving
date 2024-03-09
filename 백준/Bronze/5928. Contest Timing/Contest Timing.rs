use std::io;
use std::io::{BufRead, BufReader, BufWriter, Write, StdinLock, StdoutLock};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    time: (u32, u32, u32),
    answer: String,
}

struct Data {}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            time: (0, 0, 0),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        let mut input = String::new();
        self.reader.read_line(&mut input).unwrap();
        let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
        let mut input = || input.next().unwrap();
        self.time = (input(), input(), input());
    }

    fn solve(&mut self) {
        let end_time = self.time.0 * 24 * 60 + self.time.1 * 60 + self.time.2;
        let begin_time = 11 * 24 * 60 + 11 * 60 + 11;
        if end_time < begin_time {
            self.answer.push_str(&(-1).to_string());
        } else {
            self.answer.push_str(&((self.time.0 * 24 * 60 + self.time.1 * 60 + self.time.2) - (11 * 24 * 60 + 11 * 60 + 11)).to_string());
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {}
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}