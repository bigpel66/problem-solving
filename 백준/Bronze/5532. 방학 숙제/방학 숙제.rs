use std::io;

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
        for _ in 0..5 {
            let mut input = String::new();
            io::stdin().read_line(&mut input).expect("wrong input");
            let input: u32 = input.trim().parse().expect("number parse");
            self.vec.push(input);
        }
    }

    fn solve(&mut self) {
        let korean = *self.vec.get(1).expect("no korean total") as f64;
        let korean = korean / *self.vec.get(3).expect("no korean day") as f64;
        let korean = korean.ceil();
        let math = *self.vec.get(2).expect("no math total") as f64;
        let math = math / *self.vec.get(4).expect("no math day") as f64;
        let math = math.ceil();
        let max = korean.max(math) as u32;
        self.answer = (*self.vec.get(0).unwrap_or(&0u32) - max).to_string();
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