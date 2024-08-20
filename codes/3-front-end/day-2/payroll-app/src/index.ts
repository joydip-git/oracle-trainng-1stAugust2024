import { EmployeeList } from "./components/employee-list";
import { FilterEmployees } from "./components/filter-employees";
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





function filter(sal: number) {
    manager.filterRecords(sal)
        .forEach(
            e => console.log(e.name + ' received salary of ' + e.totalSalary)
        )
}

const table = EmployeeList({ employees: manager.fetchAll() })

document.body.appendChild(FilterEmployees({ filterHandler: filter }))
document.body.appendChild(table)



//filtering employees with total salary more than 11000
//and print their details


// const button = document.createElement('button')
// button.innerText = "Load"
// button.style.width = '80px'
// button.style.height = '50px'
// button.style.backgroundColor = 'burlywood'
// button.style.color = 'black'
// button.style.borderWidth = '1px'
// button.style.borderStyle = 'solid'
// button.style.borderRadius = '5px'
// button.style.fontFamily = 'consolas'
// button.style.fontSize = 'medium'
// button.style.margin = '50px'

// button.addEventListener('click',)

//document.body.appendChild(button)