// const { add, subtract } = require('./utility')

// const { add, subtract } = utilityModuleExportsObj

//import { add, subtract } from './utility'
//const { add, subtract } = utilityModuleExportsObj

const obj = {
    id: 1,
    name: 'anil',
    salary: 1000,
    isManager: true,
    print: function () {
        return `
            Id:${this.id}, 
            Name:${this.name}, 
            Salary:${this.salary}
            Manager:${this.isManager ? 'yes' : 'no'}
        `
    }
}

console.log(obj.print());

// const id = obj.id
// const name = obj.name
// const salary = obj.salary

//const { id: id, name: name, salary: salary } = obj
const { id, name, salary } = obj

console.log(id, name, salary);


//obj['location'] = 'bangalore'
// const copy = {}
// for (const propName in obj) {
//     const propValue = obj[propName]
//     copy[propName] = propValue
// }

// console.log(obj);
// console.log(copy);

//spread operator (...)
const copy = { ...obj }

const numbers = [1, 2, 3, 4]
// const first = numbers[0]
// const fourth = numbers[3]
const [first, , third] = numbers
console.log(first, third);

const copyOfNumbers = [...numbers]

//rest operator (...)
//it is used to declare an array as part of a function's argument list
//this array accepts any number of arguments
//this array should be the LAST in the argument list
//there can be only ONE such array as part of the function's argument list
function calculateAverage(name, ...marks) {
    let sum = 0;
    let avg = 0;
    marks.forEach(
        (n) => sum += n
    );
    avg = sum / marks.length
    return avg
}

console.log(calculateAverage('anil', 40, 35, 45))
console.log(calculateAverage('sunil', 40, 35, 45, 48, 38))

