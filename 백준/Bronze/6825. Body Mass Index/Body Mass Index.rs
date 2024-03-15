use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    weight: f64,
    height: f64,
}

impl<'a> Problem<'a> {
    fn new() -> Problem<'a> {
        Problem {
            reader: BufReader::new(io::stdin().lock()),
            writer: BufWriter::new(io::stdout().lock()),
            data: Data::new(0.0, 0.0),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        let mut input = String::new();
        self.reader.read_to_string(&mut input).unwrap();
        let mut input = input.split_ascii_whitespace().map(|e| e.parse::<f64>().unwrap());
        let mut input = || input.next().unwrap();
        self.data = Data::new(input(), input());
    }

    fn solve(&mut self) {
        let bmi = self.data.weight / (self.data.height * self.data.height);
        if bmi > 25.0 {
            self.answer.push_str("Overweight");
        } else if bmi >= 18.5 && bmi <= 25.0 {
            self.answer.push_str("Normal weight");
        } else if bmi < 18.5 {
            self.answer.push_str("Underweight");
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new(weight: f64, height: f64) -> Data {
        Data {
            weight,
            height,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}