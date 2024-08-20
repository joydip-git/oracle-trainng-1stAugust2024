import EmployeeBusinessManager from "./manager/employee-business-manager"
import { Developer } from "./models/developer";
import Hr from "./models/hr";

//create instance of manager class
const manager = new EmployeeBusinessManager();


//adding employee type objects in the repository via manager
console.log(manager.add(new Developer(1, 'anil', 1000, 2000, 3000, 4000)) ? "added" : "not added");
console.log(manager.add(new Hr(2, 'sunil', 1200, 2200, 3200, 4200)) ? "added" : "not added")
console.log(manager.add(new Developer(3, 'mahesh', 1500, 2500, 3500, 4500)) ? "added" : "not added")
console.log(manager.add(new Hr(4, 'suresh', 2000, 3000, 4000, 5000)) ? "added" : "not added")

//printing all employees
manager.fetchAll()
    .forEach(e => console.log(e))

//filtering employees with total salary more than 11000
//and print their details
manager.filterRecords(11000)
    .forEach(
        e => console.log(e.name + ' received salary of ' + e.totalSalary)
    )