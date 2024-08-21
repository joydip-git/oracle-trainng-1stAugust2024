type HeaderProps = {
    dataValue: string,
    numValue?: number,
    numHandler: () => void
}
const Header = (props: Readonly<HeaderProps>) => {
    console.log('header loaded');
    let design
    if (props.numValue !== undefined) {
        design = <span>{props.numValue}</span>
    }
    //args.dataValue = 13
    return (
        <div>
            <h2>{props.dataValue}</h2>
            <br />
            <span>
                Number: &nbsp;
                {design}
                <br />
                {
                    /*args.numValue && args.numValue*/
                    //props.numValue !== undefined ? props.numValue : 'NA'
                }
            </span>
            <br />
            <button type="button" onClick={props.numHandler}>Increase</button>
        </div>
    )
}

export default Header