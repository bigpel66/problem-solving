use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    antenna: u32,
    eyes: u32,
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
        self.data = Data::of(input(), input());
    }

    fn solve(&mut self) {
        if self.data.antenna >= 3 && self.data.eyes <= 4 {
            self.answer.push_str("TroyMartian\n");
        }
        if self.data.antenna <= 6 && self.data.eyes >= 2 {
            self.answer.push_str("VladSaturnian\n");
        }
        if self.data.antenna <= 2 && self.data.eyes <= 3 {
            self.answer.push_str("GraemeMercurian\n");
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            antenna: 0,
            eyes: 0,
        }
    }

    fn of(antenna: u32, eyes: u32) -> Data {
        Data {
            antenna,
            eyes,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}