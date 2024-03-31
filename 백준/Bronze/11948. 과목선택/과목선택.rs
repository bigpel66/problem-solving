use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Vec<u32>,
    answer: String,
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
        for _i in 0..6 {
            self.data.push(input());
        }
    }

    fn solve(&mut self) {
        let sci = self.min(0, 4);
        let his = self.min(4, 6);
        let sum: u32 = self.data.iter().sum();
        self.answer.push_str(&*(sum - sci - his).to_string());
    }

    fn min(&self, begin: u32, end: u32) -> u32 {
        let mut min = self.data[begin as usize];
        for i in begin + 1..end {
            if min > self.data[i as usize] {
                min = self.data[i as usize];
            }
        }
        min
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
