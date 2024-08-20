//type inference
var value = 12

type myType = number | undefined | null

function add(a: number, b: number): number {
    return (a + b)
    //return undefined |null
}
type fnType = (a: number, b: number) => number
type fnRefType = (a?: any) => void
function invokeAny(fnRef: fnRefType, a?: any) {
    fnRef()
}
invokeAny(() => console.log('hello'))
function invoke(fnRef: fnType, a: number, b: number) {
    fnRef(a, b)
}
invoke(add, 12, 13);

type productType = {
    id: number,
    name: string,
    price: number
}

type someType = {
    description?: string
}

type mainType = productType & someType

const products: mainType[] = [
    {
        id: 1,
        name: '',
        price: 1,
        description: ''
    }
]

interface Product {
    id: number;
    name: string;
    price: number;
    description?: string;
}

const productRecords: Product[] = [
    { id: 1, name: '', price: 1 }
]

interface OperationsA {
    add(a: number, b: number): number;
}
interface Operations extends OperationsA {
    subtract(a: number, b: number): number;
}

class OperationsImpl implements Operations {
    subtract(a: number, b: number): number {
        throw new Error("Method not implemented.")
    }
    add(a: number, b: number): number {
        throw new Error("Method not implemented.")
    }
}

class Person {
    public get isManager(): boolean {
        return this._isManager
    }
    public set isManager(value: boolean) {
        this._isManager = value
    }
    public get salary(): number {
        return this._salary
    }
    public set salary(value: number) {
        this._salary = value
    }
    public get name(): string {
        return this._name
    }
    public set name(value: string) {
        this._name = value
    }
    public get id(): number {
        return this._id
    }
    public set id(value: number) {
        this._id = value
    }
    // id: number;
    // name: string;
    // salary: number;
    // isManager: boolean;

    // constructor(id: number, name: string, salary: number, isManager: boolean) {
    //     this.id = id
    //     this.name = name
    //     this.salary = salary
    //     this.isManager = isManager
    // }

    constructor(private _id: number, private _name: string, private _salary: number, private _isManager: boolean) {

    }

    print() {
        return this.id + " " + this.name + " " + this.salary + " " + (this.isManager ? " manager" : " not a manager")
    }
}

class Trainer extends Person {
    public get subject(): string {
        return this._subject
    }
    public set subject(value: string) {
        this._subject = value
    }
    // private subject: string;
    // constructor(id: number, name: string, salary: number, isManager: boolean, subject: string) {
    //     super(id, name, salary, isManager)
    //     this.subject = subject
    // }
    constructor(id: number, name: string, salary: number, isManager: boolean, private _subject: string) {
        super(id, name, salary, isManager)

    }
    print() {
        var info = super.print()
        return info + " " + this.subject
    }
}


