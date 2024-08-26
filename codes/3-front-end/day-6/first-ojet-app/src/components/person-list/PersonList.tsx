import MutableArrayDataProvider = require("ojs/ojmutablearraydataprovider")

import "ojs/ojlistview"
import "ojs/ojselectsingle"

import { ojListView } from "ojs/ojlistview";
import { ojSelectSingle } from "ojs/ojselectsingle";

import { useState } from "preact/hooks";
import { ItemContext } from "@oracle/oraclejet/ojcommontypes";

// import { Person } from "../models/person";
// import { people } from "../data/people";

type Person = {
    id: number,
    name: string,
    salary: number
}

const people: Person[] = [
    {
        id: 3,
        name: 'anil',
        salary: 2000
    },
    {
        id: 1,
        name: 'joydip',
        salary: 3000
    },
    {
        id: 2,
        name: 'sunil',
        salary: 1000
    }
]

const PersonList = () => {
    const dp: MutableArrayDataProvider<Person['id'], Person> = new MutableArrayDataProvider<Person['id'], Person>(
        people,
        {
            keyAttributes: 'id',
            implicitSort: [{ attribute: 'id', direction: 'ascending' }]
        }
    );

    const [selected, setSelected] = useState(people[0].name)

    const personTemplate = (context: ojListView.ItemTemplateContext<Person['id'], Person>) => {
        return (
            <>
                <span class="oj-typography-body-md oj-text-color-primary">
                    {context.data.name}
                </span>
                &nbsp;&nbsp;
                <span class="oj-typography-body-sm oj-text-color-secondary">
                    {context.data.salary}
                </span>
            </>
        )
    }
    return (
        <div>
            <h2>List of People</h2>
            <br />
            <oj-list-view
                class="oj-listview-item-padding-off"
                id="listPeople"
                data={dp}
                gridlines={{ item: 'visible' }}
            >
                <template
                    slot="itemTemplate"
                    render={personTemplate}
                >
                </template>
            </oj-list-view>

            <br />
            <br />
            <oj-select-single
                id="ddlPeople"
                data={dp}
                label-hint="Select a Person from the list"
                itemText={
                    (context: ItemContext<Person['id'], Person>) => {
                        return context.data.name
                    }
                }
            >
                <template slot='itemTemplate' key="id" render=
                    {
                        (context: ojSelectSingle.ItemTemplateContext<Person['id'], Person>) => {
                            return <span>{context.data.name}</span>
                        }
                    }>

                </template>
            </oj-select-single>
        </div>
    )
}

export default PersonList