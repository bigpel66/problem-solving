use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    a: u32,
    b: u32,
    c: u32,
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
        self.data = Data::of(input(), input(), input());
    }

    fn solve(&mut self) {
        self.answer.push_str("The 1-3-sum is ");
        self.answer.push_str(&(91 + self.data.a + self.data.b * 3 + self.data.c).to_string());
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            a: 0,
            b: 0,
            c: 0,
        }
    }

    fn of(a: u32, b: u32, c: u32) -> Data {
        Data {
            a,
            b,
            c,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}