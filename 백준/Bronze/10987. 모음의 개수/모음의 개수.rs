use std::collections::HashSet;
use std::io;
use std::io::{BufRead, BufReader, BufWriter, StdinLock, StdoutLock, Write};

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
        self.reader.read_line(&mut input).unwrap();
        self.data.word = input;
    }

    fn solve(&mut self) {
        let mut set: HashSet<char> = HashSet::new();
        set.insert('a');
        set.insert('e');
        set.insert('i');
        set.insert('o');
        set.insert('u');
        let mut count = 0;
        for w in self.data.word.chars() {
            if set.contains(&w) {
                count += 1;
            }
        }
        self.answer.push_str(&count.to_string())
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
