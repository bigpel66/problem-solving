use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    target: u32,
    cars: Vec<u32>,
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
        self.data.target = input();
        for _i in 1..6 {
            self.data.cars.push(input());
        }
    }

    fn solve(&mut self) {
        let mut count = 0;
        for c in &self.data.cars {
            if c % 10 == self.data.target {
                count += 1
            }
        }
        self.answer.push_str(&count.to_string());
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            target: 0,
            cars: Vec::new(),
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
