export class Employee {
    //public totalSalary: number;
    totalSalary = 0;

    constructor(public id: number, public name: string, public basicPayment: number, public daPayment: number, public hraPayment: number) {
        //this.totalSalary = 0
    }
    calculateSalary() {
        this.totalSalary = this.basicPayment + this.daPayment + this.hraPayment
    }
}