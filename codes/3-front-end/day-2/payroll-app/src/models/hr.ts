import { Employee } from "./employee";

export default class Hr extends Employee {
    constructor(id: number, name: string, basic: number, da: number, hra: number, public gratuityPayment: number) {
        super(id, name, basic, da, hra)
    }
    calculateSalary() {
        super.calculateSalary()
        this.totalSalary += this.gratuityPayment
    }
}

//export default Hr

//export const a = 100