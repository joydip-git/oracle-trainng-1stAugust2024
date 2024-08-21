type HeaderProps = {
    dataValue: string,
    numValue?: number
}
const Header = (props: Readonly<HeaderProps>) => {
    //args.dataValue = 13
    return (
        <div>
            <h2>{props.dataValue}</h2>
            <br />
            <span>
                Number: &nbsp;
                {
                    /*args.numValue && args.numValue*/
                    props.numValue ? props.numValue : 'NA'
                }
            </span>
        </div>
    )
}

export default Header