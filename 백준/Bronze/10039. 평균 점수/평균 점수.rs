use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    scores: Vec<u32>,
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
        for _i in 0..5 {
            let mut val = input();
            if val < 40 {
                val = 40;
            }
            self.data.scores.push(val);
        }
    }

    fn solve(&mut self) {
        let mut sum: u32 = 0;
        for val in self.data.scores.iter() {
            sum += val;
        }
        self.answer.push_str(&(sum as f64 / 5.0).to_string());
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data { scores: Vec::new() }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
