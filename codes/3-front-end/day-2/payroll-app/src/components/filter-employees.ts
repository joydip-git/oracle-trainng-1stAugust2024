type FilterEmployeesProps = {
    filterHandler: (val: number) => void
}
export function FilterEmployees(props: Readonly<FilterEmployeesProps>) {
    const label = document.createElement('label')
    label.innerText = "Salary: "

    const txtBox = document.createElement('input')
    txtBox.type = 'text'
    txtBox.style.width = '200px'
    txtBox.addEventListener('change', function (e) {
        const input = <HTMLInputElement>e.target
        //console.log(input?.value)
        props.filterHandler(Number(input?.value))
    })

    const div = document.createElement('div')
    div.append(label, txtBox)

    return div
}