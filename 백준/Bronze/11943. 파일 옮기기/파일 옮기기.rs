use std::cmp::min;
use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Vec<Data>,
    answer: String,
}

struct Data {
    apple: u32,
    orange: u32,
}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            data: Vec::new(),
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
        for _i in 0..2 {
            self.data.push(Data::new(input(), input()));
        }
    }

    fn solve(&mut self) {
        let val = min(
            self.data.get(0).unwrap().apple + self.data.get(1).unwrap().orange,
            self.data.get(1).unwrap().apple + self.data.get(0).unwrap().orange,
        );
        self.answer.push_str(&val.to_string());
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new(apple: u32, orange: u32) -> Data {
        Data { apple, orange }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
