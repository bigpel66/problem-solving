use std::io;
use std::io::{BufRead, BufReader, BufWriter, Write, StdinLock, StdoutLock};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    vec: Vec<Data>,
    answer: String,
}

struct Data {
    pair: (u32, u32),
}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            vec: Vec::new(),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        loop {
            let mut input = String::new();
            self.reader.read_line(&mut input).unwrap();
            let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
            let mut input = || input.next().unwrap();
            let t = (input(), input());
            if t.0 == 0 && t.1 == 0 {
                break;
            } else {
                self.vec.push(Data::new(t));
            }
        }
    }

    fn solve(&mut self) {
        for i in &self.vec {
            let sum = i.pair.0 + i.pair.1;
            self.answer.push_str(&sum.to_string());
            self.answer.push('\n');
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new(t: (u32, u32)) -> Data {
        Data {
            pair: t,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}