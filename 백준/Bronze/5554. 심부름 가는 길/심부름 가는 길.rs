use std::io;
use std::io::Read;

struct Problem {
    vec: Vec<u32>,
    answer: String,
}

impl Problem {
    fn new() -> Problem {
        Problem {
            vec: Vec::new(),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        let mut str = String::new();
        io::stdin().read_to_string(&mut str).unwrap();
        for x in str.split_ascii_whitespace() {
            let val: u32 = x.parse().unwrap();
            self.vec.push(val);
        }
    }

    fn solve(&mut self) {
        let x: u32 = self.vec.iter().sum();
        self.answer.push_str(&(x / 60).to_string());
        self.answer.push('\n');
        self.answer.push_str(&(x % 60).to_string());
    }

    fn output(&self) {
        println!("{}", self.answer);
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}