import { Employee } from "../models/employee"

type EmployeeListProps = {
    employees: Readonly<Employee[]>,
    value?: number
}
export function EmployeeList(props: Readonly<EmployeeListProps>) {
    //props.value = 100
    const { employees } = props

    const tableObj = document.createElement('table')

    const theadObj = document.createElement('thead')

    const headerRowObj = document.createElement('tr')

    const idColumn = document.createElement('th')
    idColumn.innerText = "ID"
    const nameColumn = document.createElement('th')
    nameColumn.innerText = "NAME"
    const salaryColumn = document.createElement('th')
    salaryColumn.innerText = "SALARY"

    //append <th> elements in the <tr>
    headerRowObj.append(idColumn, nameColumn, salaryColumn)
    //append the <tr> element in <thead>
    theadObj.appendChild(headerRowObj)
    //append the <thead> element in <table>
    tableObj.appendChild(theadObj)

    const tbodyObj = document.createElement('tbody')

    //printing all employees
    employees
        .forEach(e => {
            const dataRowObj = document.createElement('tr')

            const idCell = document.createElement('td')
            idCell.innerText = e.id.toString()

            const nameCell = document.createElement('td')
            nameCell.innerText = e.name

            const salaryCell = document.createElement('td')
            salaryCell.innerText = e.totalSalary.toString()

            dataRowObj.append(idCell, nameCell, salaryCell)
            tbodyObj.appendChild(dataRowObj)
        })

    tableObj.appendChild(tbodyObj)
    return tableObj
}