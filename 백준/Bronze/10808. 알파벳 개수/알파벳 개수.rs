use std::collections::HashMap;
use std::io;
use std::io::{BufReader, BufWriter, Read, StdinLock, StdoutLock, Write};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    word: String,
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
        self.data.word = input;
    }

    fn solve(&mut self) {
        let mut m: HashMap<char, u32> = HashMap::new();
        for i in self.data.word.chars() {
            m.insert(i, m.get(&i).unwrap_or(&0) + 1);
        }
        for i in 'a'..='z' {
            self.answer.push_str(&m.get(&i).unwrap_or(&0).to_string());
            self.answer.push(' ');
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            word: String::new(),
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}
