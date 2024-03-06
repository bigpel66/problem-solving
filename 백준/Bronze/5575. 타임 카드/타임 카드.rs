use std::io;

struct Problem {
    vec: Vec<Data>,
    answer: String,
}

struct Data {
    duration: u32,
}

struct Work {
    stamp: u32,
}


impl Problem {
    fn new() -> Problem {
        Problem {
            vec: Vec::new(),
            answer: String::new(),
        }
    }

    fn input(&mut self) {
        for _i in 0..3 {
            let mut input = String::new();
            io::stdin().read_line(&mut input).unwrap();
            let mut input = input.split_ascii_whitespace().map(|e| e.parse::<u32>().unwrap());
            let mut input = || input.next().unwrap();
            self.vec.push(Data::new(Work::new(input(), input(), input()), Work::new(input(), input(), input())));
        }
    }

    fn solve(&mut self) {
        self.format_push(self.vec.get(0).unwrap().duration_to_time());
        self.format_push(self.vec.get(1).unwrap().duration_to_time());
        self.format_push(self.vec.get(2).unwrap().duration_to_time());
    }

    fn format_push(&mut self, time: (u32, u32, u32)) {
        self.answer.push_str(&time.0.to_string());
        self.answer.push(' ');
        self.answer.push_str(&time.1.to_string());
        self.answer.push(' ');
        self.answer.push_str(&time.2.to_string());
        self.answer.push('\n');
    }

    fn output(&self) {
        println!("{}", self.answer);
    }
}

impl Data {
    fn new(begin: Work, end: Work) -> Data {
        Data {
            duration: &end.stamp - &begin.stamp,
        }
    }

    fn duration_to_time(&self) -> (u32, u32, u32) {
        let second = self.duration % 60;
        let mut minute = self.duration / 60;
        let hour = minute / 60;
        minute %= 60;
        (hour, minute, second)
    }
}

impl Work {
    fn new(hour: u32, minute: u32, second: u32) -> Work {
        Work {
            stamp: hour * 60 * 60 + minute * 60 + second,
        }
    }
}

fn main() {
    let mut problem = Problem::new();
    problem.input();
    problem.solve();
    problem.output();
}