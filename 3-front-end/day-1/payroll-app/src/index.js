class Employee {
    constructor(id, name, basic, da, hra) {
        this.id = id
        this.name = name
        this.basicPayment = basic
        this.daPayment = da
        this.hraPayment = hra
        this.totalSalary = 0
    }
    calculateSalary() {
        this.totalSalary = this.basicPayment + this.daPayment + this.hraPayment
    }
}

class Develeoper extends Employee {
    constructor(id, name, basic, da, hra, incentive) {
        super(id, name, basic, da, hra)
        this.incentivePayment = incentive
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.incentivePayment
    }
}

class Hr extends Employee {
    constructor(id, name, basic, da, hra, gratuity) {
        super(id, name, basic, da, hra)
        this.gratuityPayment = gratuity
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.gratuityPayment
    }
}

const employees = []
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

/*
for (const element of employees) {
if (element instanceof Develeoper) { }
else if (element instanceof Hr) { }
}
*/