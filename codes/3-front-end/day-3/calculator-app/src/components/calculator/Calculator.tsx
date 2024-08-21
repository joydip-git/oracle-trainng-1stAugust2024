import { FormEvent, useState } from 'react'
type FormStateType = {
    first: number,
    second: number,
    result: number
}
const Calculator = () => {
    const [formData, setFormData] = useState<FormStateType>({
        first: 0,
        second: 0,
        result: 0
    })
    const [choice, setChoice] = useState(0)

    const updateChoice = (value: number) => {
        setChoice(value)
    }
    const updateFormData = (propName: string, e: FormEvent) => {
        const element = e.target as HTMLInputElement;
        if (element.value && element.value !== '') {
            setFormData(
                (current) => {
                    return {
                        ...current,
                        [propName]: +(element.value)
                    }
                }
            )
        }
    }
    const calculate = () => {
        let result = 0
        switch (choice) {
            case 1:
                result = formData.first + formData.second
                break;
            case 2:
                result = formData.first - formData.second
                break;
            case 3:
                result = formData.first * formData.second
                break;
            case 4:
                result = formData.first / formData.second
                break;

            default:
                break;
        }
        setFormData(
            (current) => {
                return {
                    ...current,
                    result: result
                }
            }
        )
    }
    return (
        <fieldset>
            <legend>Calculator</legend>
            <br />
            <form>
                <div>
                    <label htmlFor="radioAdd">Add: &nbsp;</label>
                    <input type="radio" name="ops" id="radioAdd"
                        onChange={
                            () => updateChoice(1)
                        }
                    />

                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="radioSubtract">Subtract: &nbsp;</label>
                    <input type="radio" name="ops" id="radioSubtract"
                        onChange={
                            () => updateChoice(2)
                        }
                    />

                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="radioMultiply">Multiply: &nbsp;</label>
                    <input type="radio" name="ops" id="radioMultiply"
                        onChange={
                            () => updateChoice(3)
                        }
                    />

                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <label htmlFor="radioDivide">Divide: &nbsp;</label>
                    <input type="radio" name="ops" id="radioDivide"
                        onChange={
                            () => updateChoice(4)
                        }
                    />
                </div>
                <div>
                    <label htmlFor="txtFirst">Enter First: &nbsp;</label>
                    <input type="text" id="txtFirst"
                        value={formData.first}
                        onInput={
                            (e) => updateFormData('first', e)
                        }
                    />
                </div>
                <div>
                    <label htmlFor="txtSecond">Enter Second: &nbsp;</label>
                    <input type="text" id="txtSecond"
                        value={formData.second}
                        onInput={
                            (e) => updateFormData('second', e)
                        }
                    />
                </div>
                <div>
                    <input type="button" value="Calculate" onClick={calculate} />
                </div>
            </form>
            <br />
            <div>
                <label htmlFor="txtResult">Result: &nbsp;</label>
                <input type="text" id="txtResult" readOnly value={formData.result} />
            </div>
        </fieldset>
    )
}

export default Calculator