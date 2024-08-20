/*
'use strict'
//1. object literal syntax
var objRef = {
    //value properties
    id: 1,
    name: 'anil',
    isManager: true,
    salary: 1000,
    //functional property
    print: function () {
        return this.id + " " + this.name + " " + this.salary + " " + (this.isManager ? " manager" : " not a manager");
    }
}
//dynamically expanding an existing object
objRef.location = 'Bangalore'
objRef.sayHi = function () {
    console.log('hi ' + this.name);
}
*/
//2. constructor function
function person(idValue, nameValue, salaryValue, status) {
    this.id = idValue
    this.name = nameValue
    this.salary = salaryValue
    this.isManager = status
}
person.prototype.print = function () {
    return this.id + " " + this.name + " " + this.salary + " " + (this.isManager ? " manager" : " not a manager")
}
function trainer(idValue, nameValue, salaryValue, status, subject) {
    person.call(this, idValue, nameValue, salaryValue, status)
    this.subject = subject
    this.print = function () {
        //var info = person.prototype.print.apply(this)
        var info = this.__proto__.print.apply(this)
        return info + " " + this.subject
    }
}
Object.setPrototypeOf(trainer.prototype, person.prototype)
console.log(person.prototype);
console.log(trainer.prototype);
//person(1, 'anil', 1000, true)
//person(2, 'sunil', 2000, true)
var anilPersonRef = new trainer(1, 'joydip', 1000, false, "JavaScript")
// console.log(global);
trainer.prototype.sayHi = function () {
    return "hi ....";
}
console.log(anilPersonRef.print());
console.log(anilPersonRef.sayHi());
