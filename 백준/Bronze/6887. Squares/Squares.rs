use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    square: u32,
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
        self.data.square = input();
    }

    fn solve(&mut self) {
        self.answer.push_str("The largest square has side length ");
        self.answer.push_str(&(self.data.square as f64).sqrt().floor().to_string());
        self.answer.push_str(".");
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            square: 0,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}