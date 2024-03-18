use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    begin: u32,
    end: u32,
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
        let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
        let mut input = || input.next().unwrap();
        self.data.begin = input();
        self.data.end = input();
    }

    fn solve(&mut self) {
        for i in (self.data.begin..self.data.end + 1).step_by(60) {
            self.answer.push_str("All positions change in year ");
            self.answer.push_str(&i.to_string());
            self.answer.push_str("\n");
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            begin: 0,
            end: 0,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}