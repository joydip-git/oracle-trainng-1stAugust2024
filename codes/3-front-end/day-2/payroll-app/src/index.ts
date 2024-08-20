class Employee {
    //public totalSalary: number;
    totalSalary = 0;

    constructor(public id: number, public name: string, public basicPayment: number, public daPayment: number, public hraPayment: number) {
        //this.totalSalary = 0
    }
    calculateSalary() {
        this.totalSalary = this.basicPayment + this.daPayment + this.hraPayment
    }
}

class Develeoper extends Employee {
    constructor(id: number, name: string, basic: number, da: number, hra: number, public incentivePayment: number) {
        super(id, name, basic, da, hra)
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.incentivePayment
    }
}

class Hr extends Employee {
    constructor(id: number, name: string, basic: number, da: number, hra: number, public gratuityPayment: number) {
        super(id, name, basic, da, hra)
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.gratuityPayment
    }
}

//creating a repository for employee type objects
const employees: Employee[] = []

//adding employee type objects in the repository
employees.push(new Develeoper(1, 'anil', 1000, 2000, 3000, 4000))
employees.push(new Hr(2, 'sunil', 1200, 2200, 3200, 4200))
employees.push(new Develeoper(3, 'mahesh', 1500, 2500, 3500, 4500))
employees.push(new Hr(4, 'suresh', 2000, 3000, 4000, 5000))

//calculating total salary of each employee
employees.forEach(e => e.calculateSalary())

//filtering employees with total salary more than 11000
//and print their details
employees
    .filter(
        e => e.totalSalary > 11000
    )
    .forEach(
        e => console.log(e.name + ' received salary of ' + e.totalSalary)
    )