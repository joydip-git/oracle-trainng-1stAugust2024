class Person {
    constructor(idValue, nameValue, salaryValue, status) {
        this.id = idValue
        this.name = nameValue
        this.salary = salaryValue
        this.isManager = status
    }
    print() {
        return this.id + " " + this.name + " " + this.salary + " " + (this.isManager ? " manager" : " not a manager")
    }
}

class Trainer extends Person {
    constructor(idValue, nameValue, salaryValue, status, subject) {
        super(idValue, nameValue, salaryValue, status)
        this.subject = subject

    }
    print() {
        var info = super.print()
        return info + " " + this.subject
    }
}

var anilTrainerRef = new Trainer(1, 'anil', 1000, false, 'JavaScript')
console.log(anilTrainerRef.print());
