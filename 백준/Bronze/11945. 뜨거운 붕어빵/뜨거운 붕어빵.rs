use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};
use std::process::exit;

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Vec<String>,
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
        let mut input = input.split_ascii_whitespace();
        let mut input = || input.next().unwrap();
        let iteration: (u32, u32) = (
            input().parse::<u32>().unwrap(),
            input().parse::<u32>().unwrap(),
        );
        if iteration.0 == 0 || iteration.1 == 0 {
            exit(0);
        }
        for _i in 0..iteration.0 {
            self.data.push(String::from(input()));
        }
    }

    fn solve(&mut self) {
        for i in self.data.iter() {
            self.answer.push_str(&i.chars().rev().collect::<String>());
            self.answer.push('\n');
        }
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
