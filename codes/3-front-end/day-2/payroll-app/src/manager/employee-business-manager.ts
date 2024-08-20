import { Employee } from "../models/employee";
import { employees } from "../repository/employees";
import { BusinessManager } from "./business-manager";

export default class EmployeeBusinessManager implements BusinessManager<Employee, number> {
    add(data: Employee): boolean {
        data.calculateSalary()
        if (employees.length > 0) {
            const index = employees.findIndex(e => e.id === data.id)
            if (index === -1) {
                employees.push(data)
                return true
            } else
                return false
        } else {
            employees.push(data)
            return true
        }
    }
    fetchAll(): Readonly<Employee[]> {
        // const copy = [...employees]
        // return copy
        return employees
    }
    filterRecords(value: number): Readonly<Employee[]> {
        return employees.filter(e => e.totalSalary >= value)
    }

}