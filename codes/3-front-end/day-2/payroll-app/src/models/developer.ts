import { Employee } from "./employee";

export class Developer extends Employee {
    constructor(id: number, name: string, basic: number, da: number, hra: number, public incentivePayment: number) {
        super(id, name, basic, da, hra)
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.incentivePayment
    }
}