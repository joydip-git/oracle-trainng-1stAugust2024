import React, { useState } from 'react'

const ItemList = () => {
    const [numbers, setNumbers] = useState([1, 2, 3, 4, 5])
    const liElements = numbers.map(
        (value, index) => {
            return <li key={value}>{value}</li>
        }
    )

    const sortNumbers = () => {
        const copy = [...numbers]
        copy.sort((a, b) => b - a)
        setNumbers(copy)
    }
    return (
        <div>
            <div>
                <label htmlFor="numberList">List of Numbers: &nbsp;</label>
                <ul id='numberList'>
                    {
                        liElements
                    }
                </ul>
            </div>
            <br />
            <div>
                <label htmlFor="ddlNumbers">Select a Number: &nbsp;</label>
                <select id="ddlNumbers">
                    <option value="0" selected disabled>--select--</option>
                    {
                        numbers.map(
                            (element, i) => <option value={i + 1} key={element}>{element}</option>
                        )
                    }
                </select>
            </div>
            <br />
            <button type="button" onClick={sortNumbers}>Sort</button>
        </div>
    )
}

export default ItemList