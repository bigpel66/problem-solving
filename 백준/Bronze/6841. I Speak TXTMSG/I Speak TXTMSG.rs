use std::collections::HashMap;
use std::io;
use std::io::{BufReader, BufWriter, Write, StdinLock, StdoutLock, Read};

struct Problem<'a> {
    reader: BufReader<StdinLock<'a>>,
    writer: BufWriter<StdoutLock<'a>>,
    data: Data,
    answer: String,
}

struct Data {
    dict: HashMap<String, String>,
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
        self.data.dict.insert(String::from("CU"), String::from("see you"));
        self.data.dict.insert(String::from(":-)"), String::from("I’m happy"));
        self.data.dict.insert(String::from(":-("), String::from("I’m unhappy"));
        self.data.dict.insert(String::from(";-)"), String::from("wink"));
        self.data.dict.insert(String::from(":-P"), String::from("stick out my tongue"));
        self.data.dict.insert(String::from("(~.~)"), String::from("sleepy"));
        self.data.dict.insert(String::from("TA"), String::from("totally awesome"));
        self.data.dict.insert(String::from("CCC"), String::from("Canadian Computing Competition"));
        self.data.dict.insert(String::from("CUZ"), String::from("because"));
        self.data.dict.insert(String::from("TY"), String::from("thank-you"));
        self.data.dict.insert(String::from("YW"), String::from("you’re welcome"));
        self.data.dict.insert(String::from("TTYL"), String::from("talk to you later"));
    }

    fn solve(&mut self) {
        let mut input = String::new();
        self.reader.read_to_string(&mut input).unwrap();
        let mut input = input.split_ascii_whitespace();
        let mut input = || input.next().unwrap();
        loop {
            let str = String::from(input());
            let entry = self.data.dict.get(&str).or(Option::from(&str)).unwrap();
            self.answer.push_str(entry);
            self.answer.push_str("\n");
            if str == "TTYL" {
                break
            }
        }
    }

    fn output(&mut self) {
        writeln!(self.writer, "{}", self.answer).unwrap();
    }
}

impl Data {
    fn new() -> Data {
        Data {
            dict: HashMap::new()
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}