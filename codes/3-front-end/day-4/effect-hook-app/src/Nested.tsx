import { useEffect } from "react"

type NestedProps = {
    numValue: number,
    numValueHandler: () => void
}
const Nested = (props: Readonly<NestedProps>) => {

    //everytime
    useEffect(
        () => {
            console.log('effect code everytime');

            return () => {
                console.log('cleanup everytime (next cycle)');
            }
        }
    )
    //when numValue changes
    useEffect(
        () => {
            console.log('effect code only when numValue changes');

            return () => {
                console.log('cleanup only when numValue changes (next cycle-if numvalue changes again)');
            }
        },
        [props.numValue]
    )
    //one time
    useEffect(
        () => {
            console.log('effect code only ONE time (mounted)');

            return () => {
                console.log('cleanup only when unmounted');
            }
        },
        []
    )

    return (
        <div>
            Num Value: &nbsp;{props.numValue}
            <br />
            <button type="button" onClick={props.numValueHandler}>Increase</button>
        </div>
    )
}

export default Nested