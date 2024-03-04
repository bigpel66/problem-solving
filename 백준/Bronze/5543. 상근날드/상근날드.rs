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

    fn smallest(vec: &[u32]) -> u32 {
        let mut val = vec.get(0).unwrap();
        for  v in vec.iter() {
            if val > v {
                val = v;
            }
        }
        *val
    }

    fn solve(&mut self) {
        let i = Self::smallest(&self.vec[0..3]);
        let j = Self::smallest(&self.vec[3..5]);
        self.answer = (i + j - 50).to_string();
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