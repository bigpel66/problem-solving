use std::io;

struct Problem {
    vec: Vec<Data>,
    answer: String,
}

struct Data {
    total: u32,
}

impl Problem {
    fn new() -> Problem {
        Problem {
            vec: Vec::new(),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        for _i in 0..2 {
            let mut input = String::new();
            io::stdin().read_line(&mut input).unwrap();
            let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
            let mut input = || input.next().unwrap();
            self.vec.push(Data::new(input(), input(), input(), input()))
        }
    }

    fn solve(&mut self) {
        let v1 = self.vec.get(0).unwrap().total;
        let v2 = self.vec.get(1).unwrap().total;
        if v1 > v2 {
            self.answer.push_str(&v1.to_string());
        } else {
            self.answer.push_str(&v2.to_string());
        }
    }

    fn output(&self) {
        println!("{}", self.answer);
    }
}

impl Data {
    fn new(v1: u32, v2: u32, v3: u32, v4: u32) -> Data {
        Data {
            total: v1 + v2 + v3 + v4,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}