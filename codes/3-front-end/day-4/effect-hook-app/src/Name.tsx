type NameProps = {
    nameValue: string,
    nameChangeHandler: (data: string) => void
}

const Name = (props: Readonly<NameProps>) => {
    return (
        <div>
            <label htmlFor="txtName">Name: &nbsp;</label>
            <input type="text" id='txtName' value={props.nameValue}
                onChange={
                    (e) => props.nameChangeHandler(
                        (e.target as HTMLInputElement).value)
                }
            />
        </div>
    )
}

export default Name