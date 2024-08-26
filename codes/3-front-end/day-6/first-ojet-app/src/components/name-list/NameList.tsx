import { useState } from "preact/hooks";

const NameList = () => {
    const [list, setList] = useState(['anil', 'sunil', 'joydip'])
    const sortPeople = setList(
        (currentPeople) => {
            const copy = [...currentPeople]
            copy.sort(
                (name1, name2) => name1
                    .toLocaleLowerCase()
                    .localeCompare(
                        name2.toLocaleLowerCase()
                    )
            )
            return copy
        }
    )
    return (
        <div>
            <h2>
                <label htmlFor="ddlPeople">List of People: &nbsp;</label>
            </h2>
            <br />
            <select id="ddlPeople">
                <option selected disabled>--select--</option>
                {
                    list.map(
                        name => <option key={name}>{name}</option>
                    )
                }
            </select>
            &nbsp;&nbsp;&nbsp;
            <button type="button" onClick={() => sortPeople}>Sort</button>
        </div>
    )
}

export default NameList